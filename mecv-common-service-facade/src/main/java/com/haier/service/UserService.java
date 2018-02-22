package com.haier.service;

import com.github.pagehelper.PageInfo;
import com.haier.domain.CarsTrackInfo;
import com.haier.domain.UserInfo;

import java.util.List;

/**
 * Created by Admin on 2018/2/12.
 */
public interface UserService {

    List<UserInfo> findAll();

    PageInfo<UserInfo> pageUserInfo(Integer pageNo, Integer pageSize);

    String queryRecentlyCarsTrackInfo(CarsTrackInfo carsTrackInfo);
}
