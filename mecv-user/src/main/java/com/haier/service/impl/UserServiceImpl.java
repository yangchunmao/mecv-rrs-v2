package com.haier.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.haier.dao.CarsTrackMongoDao;
import com.haier.dao.UserDao;
import com.haier.domain.CarsTrackInfo;
import com.haier.domain.UserInfo;
import com.haier.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;


/**
 * Created by Admin on 2018/2/12.
 */
@org.springframework.stereotype.Service
@Service(version = "1.0.0")
@Slf4j
public class UserServiceImpl implements UserService {

    private final String CARS_ID = "carsId";
    private final String TRACK_TIME = "trackTime";
    @Autowired
    private UserDao userDao;
    @Autowired
    private CarsTrackMongoDao carsTrackMongoDao;

    @Override
    public List<UserInfo> findAll() {
        return userDao.findAll();
    }

    @Override
    public PageInfo<UserInfo> pageUserInfo(Integer pageNo, Integer pageSize) {
        //日志级别从低到高分为TRACE < DEBUG < INFO < WARN < ERROR < FATAL，如果设置为WARN，则低于WARN的信息都不会输出。
        log.trace("日志输出 trace");
        log.debug("日志输出 debug");
        log.info("日志输出 info");
        log.warn("日志输出 warn");
        log.error("日志输出 error");
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<UserInfo> list = this.findAll();
        log.info("pageNo = {}, pageSize = {}", pageNo, pageSize);
        return new PageInfo<>(list);
    }

    @Override
    public String queryRecentlyCarsTrackInfo(CarsTrackInfo carsTrackInfo) {
        if(null == carsTrackInfo || null == carsTrackInfo.getCarsId()){
            return "请输入正确的车辆编号";
        }
        Query query = new Query();
        query.addCriteria(Criteria.where(CARS_ID).is(carsTrackInfo.getCarsId()));
        query.with(new Sort(Sort.Direction.DESC, TRACK_TIME));
        CarsTrackInfo recCars = (CarsTrackInfo) carsTrackMongoDao.findOne(query);
        if(recCars == null){
            return "无此["+carsTrackInfo.getCarsId()+"]车辆信息";
        }
        return recCars.getTrackX() + "," + recCars.getTrackY();
    }


}
