package com.qb.myblog.config;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author qinb
 * @date 2021/5/13 14:03
 */
public class JWTToken implements AuthenticationToken {
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
