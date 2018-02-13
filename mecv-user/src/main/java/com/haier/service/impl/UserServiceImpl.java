package com.haier.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.haier.dao.UserDao;
import com.haier.domain.UserInfo;
import com.haier.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Admin on 2018/2/12.
 */
//@Service
@Service(version = "1.0.0")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public List<UserInfo> findAll() {
        return userDao.findAll();
    }
}
