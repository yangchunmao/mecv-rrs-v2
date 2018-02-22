package com.haier.dao.user;

import com.alibaba.fastjson.JSON;
import com.haier.MecvUserApplicationTests;
import com.haier.domain.CarsTrackInfo;
import com.haier.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Admin on 2018/2/22.
 */
public class TestUserService extends MecvUserApplicationTests{

    @Autowired
    private UserService userService;

    @Test
    public void testPageHelper(){
        System.out.println(JSON.toJSONString(userService.pageUserInfo(null,null)));
    }

    @Test
    public void testMongodb(){
        CarsTrackInfo trackInfo = new CarsTrackInfo();
        trackInfo.setCarsId("68A59B0B0EDE11E799202C9D1E2C44FA");
        System.out.println(userService.queryRecentlyCarsTrackInfo(trackInfo));
    }

}
