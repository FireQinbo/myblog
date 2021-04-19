package com.qb.myblog.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author qinb
 * @date 2021/4/2 16:17
 */
@Configuration
@MapperScan(value = {"com.qb.myblog.mapper"})
public class MybatisPlusConfig {
}
