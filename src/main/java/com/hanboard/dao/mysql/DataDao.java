package com.hanboard.dao.mysql;

import com.hanboard.model.City;

import java.util.List;

/**
 * Created by csj on 2017/10/13.
 */
public interface DataDao {
    String findUserName1();
    void  updateUserNameCas(String  name);
    void  updateUserNameTest(String  name);
    List<City> findAllCity();
}
