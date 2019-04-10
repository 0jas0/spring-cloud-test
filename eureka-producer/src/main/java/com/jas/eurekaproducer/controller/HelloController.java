package com.jas.eurekaproducer.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <一句话描述>,
 * <详细介绍>,
 *
 * @author 琚安生
 * @since 设计wiki | 需求wiki
 */
@RestController
@RequestMapping("/hello")
public class HelloController {
    @RequestMapping("/say/{msg}")
    public String sayHello(@PathVariable(name = "msg") String msg){
        return "hello " + msg + ", this is message";
    }
}
