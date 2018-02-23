package com.haier.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/2.
 */
@Data
@NoArgsConstructor
public class CarsTrackInfo implements Serializable {

    private static final long serialVersionUID = 1467331021648893655L;

    private String trackId;

    private String trackX;

    private String trackY;

    private Date trackTime;

    private String carsId;

    private String carsNumber;

    private Date gmtCreate;

    private String createUser;

    private Date gmtModified;

    private String modifiedUser;

}
