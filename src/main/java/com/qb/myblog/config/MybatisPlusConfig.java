package com.qb.myblog.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qinb
 * @date 2021/4/2 16:17
 * @desc 配置mybatis全局扫码
 */
@Configuration
@MapperScan(value = {"com.qb.myblog.mapper"})
public class MybatisPlusConfig {
    /**
     * 配置mybatis-puls分页查询
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
