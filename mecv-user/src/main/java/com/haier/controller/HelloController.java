package com.haier.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Admin on 2018/2/11.
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String name(){
        return "Hello MecvUserApplicaton!";
    }
}
