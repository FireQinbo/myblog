package com.qb.myblog.config;

import com.qb.myblog.constant.CommonConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import javax.annotation.Resource;
import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author qinb
 * @date 2021/5/13 13:58
 */
@Configuration
@Slf4j
public class ShiroConfig {
    @Resource
    LettuceConnectionFactory lettuceConnectionFactory;

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        CustomShiroFilterFactoryBean shiroFilterFactoryBean = new CustomShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 拦截器
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/sys/cas/client/validateLogin", "anon"); //cas验证登录
        filterChainDefinitionMap.put("/sys/randomImage/**", "anon"); //登录验证码接口排除
        filterChainDefinitionMap.put("/sys/checkCaptcha", "anon"); //登录验证码接口排除
        filterChainDefinitionMap.put("/sys/login", "anon"); //登录接口排除
        filterChainDefinitionMap.put("/test/**", "anon"); //前台登录接口排除
        filterChainDefinitionMap.put("/cl/login", "anon"); //前台登录接口排除

        filterChainDefinitionMap.put("/doc.html", "anon");
        filterChainDefinitionMap.put("/**/*.js", "anon");
        filterChainDefinitionMap.put("/**/*.css", "anon");
        filterChainDefinitionMap.put("/**/*.html", "anon");
        filterChainDefinitionMap.put("/**/*.svg", "anon");
        filterChainDefinitionMap.put("/**/*.pdf", "anon");
        filterChainDefinitionMap.put("/**/*.jpg", "anon");
        filterChainDefinitionMap.put("/**/*.png", "anon");
        filterChainDefinitionMap.put("/**/*.ico", "anon");

        filterChainDefinitionMap.put("/**/*.ttf", "anon");
        filterChainDefinitionMap.put("/**/*.woff", "anon");
        filterChainDefinitionMap.put("/**/*.woff2", "anon");

        // 添加自己的过滤器并且取名为jwt
        Map<String, Filter> filterMap = new HashMap<String, Filter>(1);
        //如果cloudServer为空 则说明是单体 需要加载跨域配置
        Object cloudServer = env.getProperty(CommonConstant.CLOUD_SERVER_KEY);
        filterMap.put("jwt", new JwtFilter(cloudServer==null));
        shiroFilterFactoryBean.setFilters(filterMap);
        // <!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边
        filterChainDefinitionMap.put("/**", "jwt");

        // 未授权界面返回JSON
        shiroFilterFactoryBean.setUnauthorizedUrl("/sys/common/403");
        shiroFilterFactoryBean.setLoginUrl("/sys/common/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }
}
