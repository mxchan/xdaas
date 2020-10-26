package com.xdaas.admin.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author mathc
 * @since 2020/10/26
 */
@RestController("/user")
@Slf4j
public class UserController {

    @GetMapping("/test")
    public String test() {
        log.info("==========hello mx========");
        return "hello mx";
    }
}
