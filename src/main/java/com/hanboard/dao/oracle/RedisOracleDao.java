package com.hanboard.dao.oracle;

import com.hanboard.model.City;

import java.util.List;

/**
 * Created by csj on 2017/8/16.
 */
public interface RedisOracleDao {

    String findUserName();
    List<City> findAllCity();

}
