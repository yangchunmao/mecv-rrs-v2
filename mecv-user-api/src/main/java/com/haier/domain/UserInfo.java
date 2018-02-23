package com.haier.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Admin on 2018/2/12.
 */
@Data
@NoArgsConstructor
public class UserInfo implements Serializable{

    private int id;
    private String name;
    private String tel;
    @JSONField(format = "yyyy-MM-dd")
    private Date createTime;
}
