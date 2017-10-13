package com.hanboard.service;

import com.hanboard.dao.mysql.DataDao;
import com.hanboard.source.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by csj on 2017/10/13.
 */
@Service
@Transactional
public class DataService {
    @Autowired
    DataDao dataDao;

    @DataSource("defaultDataSource")
    public  void  dataCas(){
        dataDao.updateUserNameCas("cas2");

    }
    @DataSource("testDataSource")
    public  void  dataTest(){
        dataDao.updateUserNameTest("test2");

    }
}
