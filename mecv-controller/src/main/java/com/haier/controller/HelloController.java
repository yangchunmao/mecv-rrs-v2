package com.haier.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
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

    @RequestMapping("/pageInfo")
    public PageInfo<UserInfo> pageInfo(Integer pageNo, Integer pageSize){
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        return userService.pageUserInfo(pageNo, pageSize);
    }

}
