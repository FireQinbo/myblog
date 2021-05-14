package com.qb.myblog.config;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.qb.myblog.entity.MbUser;
import com.qb.myblog.service.IMbPermissionService;
import com.qb.myblog.service.IMbRoleService;
import com.qb.myblog.service.IMbUserService;
import com.qb.myblog.utils.JWTUtil;
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
        //添加角色集合
        info.addRoles(mbRoleService.getUserRoles(mbUser.getId()));
        //添加权限集合
        info.addStringPermissions(mbPermissionService.getRolePermissions(mbUser.getId()));
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
        return null;
    }
}
