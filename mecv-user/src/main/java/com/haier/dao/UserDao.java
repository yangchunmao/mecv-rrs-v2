package com.haier.dao;

import com.haier.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Admin on 2018/2/12.
 */
@Mapper
public interface UserDao {

    List<UserInfo> findAll();
}
