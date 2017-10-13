package com.hanboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by csj on 2017/10/13.
 */
@Service
@Transactional
public class TransactionService {

    @Autowired
    DataService dataService;

    public  void transService(){

        dataService.dataTest();
        dataService.dataCas();

    }
}
