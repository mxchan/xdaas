package com.xdaas.admin.config;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author mathc
 * @since 2020/10/19
 */
@Configuration
@MapperScan("com.xdaas.admin.dal.dataobj.mapper")
public class DruidConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.druid")
    public DataSource getDatasource() {
        return new DruidDataSource();
    }
}
