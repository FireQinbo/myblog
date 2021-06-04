package com.qb.myblog.config;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.qb.myblog.constant.CommonConstant;
import com.qb.myblog.entity.MbUser;
import com.qb.myblog.service.IMbPermissionService;
import com.qb.myblog.service.IMbRoleService;
import com.qb.myblog.service.IMbUserService;
import com.qb.myblog.utils.JWTUtil;
import com.qb.myblog.utils.RedisUtil;
import com.qb.myblog.utils.SpringContextUtils;
import com.qb.myblog.vo.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author qinb
 * @date 2021/5/13 13:59
 * @desc 用户登录鉴权和用户授权
 */
@Component
@Slf4j
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private IMbUserService mbUserService;

    @Autowired
    private IMbRoleService mbRoleService;

    @Autowired
    private IMbPermissionService mbPermissionService;

    @Autowired
    private RedisUtil redisUtil;


    /**
     * 大坑！，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        LoginUser loginUser = (LoginUser) principalCollection.getPrimaryPrincipal();
        MbUser mbUser = mbUserService.getMbUserByMobile(loginUser.getMobile());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //添加角色集合 - Set去重
        Set<String> roles = new HashSet<>(mbRoleService.getUserRoles(mbUser.getId()));
        info.addRoles(roles);
        //添加权限集合 - Set去重
        Set<String> permissions = new HashSet<>(mbPermissionService.getRolePermissions(mbUser.getId()));
        info.addStringPermissions(permissions);
        return info;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取登录token
        String token = (String) authenticationToken.getCredentials();
        if (token == null) {
            throw new AuthenticationException("token为空!");
        }
        //这里可以通过url地址判断，来针对不同url做访问控制
        //比如jeecg-boot系统有自己的sys_user，登录系统
        //但是我们还需要自己的mb_user，来登录自己的系统，这时候就需要通过url来判断需要拦截访问哪个系统的user
        //通过LoginUser对象，做统一管理登录对象
        LoginUser loginUser = null;
        if (SpringContextUtils.getHttpServletRequest().getRequestURI().contains("/mb/")) {
            //验证登录用户有效性
            loginUser = checkUserTokenEffect(token);
        }

        return new SimpleAuthenticationInfo(loginUser, token, getName());
    }

    /**
     * 验证登录用户有效性
     * @param token
     * @return
     * @throws AuthenticationException
     */
    private LoginUser checkUserTokenEffect(String token) throws AuthenticationException {
        String mobile = JWTUtil.getUsername(token);
        if (mobile == null) {
            throw new AuthenticationException("token非法无效！");
        }

        LoginUser loginUser = mbUserService.createLoginUser(mobile);
        //判断用户是否存在
        if (loginUser == null) {
            throw new AuthenticationException("用户不存在！");
        }

        //判断用户状态（使用可用 -- 待完善）


        //验证token是否超时，延时token保证用户在线操作不掉线

        if (!jwtTokenRefresh(token, loginUser.getMobile(), loginUser.getPassword())) {
            throw new AuthenticationException("token失效，请重新登录！");
        }
        return loginUser;
    }

    /**
     * JWTToken刷新生命周期 （实现： 用户在线操作不掉线功能）
     * 1、登录成功后将用户的JWT生成的Token作为k、v存储到cache缓存里面(这时候k、v值一样)，缓存有效期设置为Jwt有效时间的2倍
     * 2、当该用户再次请求时，通过JWTFilter层层校验之后会进入到doGetAuthenticationInfo进行身份验证
     * 3、当该用户这次请求jwt生成的token值已经超时，但该token对应cache中的k还是存在，则表示该用户一直在操作只是JWT的token失效了，程序会给token对应的k映射的v值重新生成JWTToken并覆盖v值，该缓存生命周期重新计算
     * 4、当该用户这次请求jwt在生成的token值已经超时，并在cache中不存在对应的k，则表示该用户账户空闲超时，返回用户信息已失效，请重新登录。
     * 注意： 前端请求Header中设置Authorization保持不变，校验有效性以缓存中的token为准。
     * 用户过期时间 = Jwt有效时间 * 2。
     * @param token
     * @param userName
     * @param password
     * @return
     */
    private boolean jwtTokenRefresh(String token, String userName, String password) {
        String redisToken = redisUtil.get(CommonConstant.PREFIX_TOKEN + token).toString();

        if (StrUtil.isNotEmpty(redisToken)) {
            //如果JWTToken已过期，则重新设置token缓存
            if (!JWTUtil.verify(token, userName, password)) {
                String newToken = JWTUtil.sign(userName, password);
                //设置token缓存一小时失效
                redisUtil.set(CommonConstant.PREFIX_TOKEN + newToken, newToken,3600);
            }

            return true;
        }

        return false;
    }
}
