package com.xdaas.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Author mathc
 * @since 2020/10/19
 */
@SpringBootApplication
public class XdaasAdminApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(XdaasAdminApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(XdaasAdminApplication.class);
    }
}
