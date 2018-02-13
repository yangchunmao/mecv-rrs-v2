package com.haier.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.haier.domain.UserInfo;
import com.haier.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Admin on 2018/2/12.
 */
@RestController
public class HelloController {

    @Reference(version = "1.0.0")
    private UserService userService;

    @RequestMapping("/")
    public String hello(){
        return "Hello MecvControllerApplication";
    }
    @RequestMapping("/findAll")
    public List<UserInfo> findAll(){
        return userService.findAll();
    }

}
