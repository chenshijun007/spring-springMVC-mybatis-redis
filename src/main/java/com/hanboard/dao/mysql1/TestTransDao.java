package com.hanboard.dao.mysql1;

import com.hanboard.model.City;

import java.util.List;

/**
 * Created by csj on 2017/9/26.
 */
public interface TestTransDao {
    String findUserName();
    List<City> findAllCity();
    void updateUserName();
}
