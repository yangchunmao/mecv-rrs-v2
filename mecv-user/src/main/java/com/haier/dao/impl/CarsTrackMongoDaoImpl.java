package com.haier.dao.impl;

import com.haier.dao.CarsTrackMongoDao;
import com.haier.domain.CarsTrackInfo;
import org.springframework.stereotype.Repository;

/**
 * Created by Admin on 2018/2/22.
 */
@Repository
public class CarsTrackMongoDaoImpl extends BaseMongoDAOImpl<CarsTrackInfo> implements CarsTrackMongoDao {
}
