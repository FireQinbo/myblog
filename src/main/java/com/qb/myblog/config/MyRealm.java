package com.qb.myblog.config;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.qb.myblog.entity.MbUser;
import com.qb.myblog.service.IMbPermissionService;
import com.qb.myblog.service.IMbRoleService;
import com.qb.myblog.service.IMbUserService;
import com.qb.myblog.utils.JWTUtil;
import com.qb.myblog.utils.SpringContextUtils;
import com.qb.myblog.vo.LoginUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
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
        String username = JWTUtil.getUsername(principalCollection.toString());
        MbUser mbUser = mbUserService.getOne(new LambdaQueryWrapper<MbUser>().eq(MbUser::getUserName, username));
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
        LoginUser loginUser;
        if (SpringContextUtils.getHttpServletRequest().getRequestURI().contains("/mb/")) {
            //验证登录用户有效性
//            loginUser =
        }

        return null;
    }

    private LoginUser checkUserTokenEffect(String token) throws AuthenticationException {
        return null;
    }
}
