package com.haier.dao.user;

import com.alibaba.fastjson.JSON;
import com.haier.MecvUserApplicationTests;
import com.haier.dao.UserDao;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Admin on 2018/2/12.
 */
public class TestUserDao extends MecvUserApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void testFindAll(){
        System.out.println(JSON.toJSONString(userDao.findAll()));
    }
}
