package com.dai.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody
//@Controller
@RestController
@Slf4j
public class HelloController {

    @RequestMapping("/hello2")
    public String handle01() {
        log.info("hahaha");
        return "Hello, Spring Boot!";
    }
}
