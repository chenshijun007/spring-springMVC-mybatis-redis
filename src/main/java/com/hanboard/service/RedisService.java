package com.hanboard.service;

import com.hanboard.dao.RedisDao;


import com.hanboard.model.City;
import com.hanboard.motan.FootService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by csj on 2017/8/16.
 */
@Service
public class RedisService {
    static Logger logger =Logger.getLogger(RedisService.class);

/*
   @Autowired
   RedisUtil redisUtil;*/
    @Autowired
    RedisDao redisDao;

    @Autowired
    BeanFactory beanFactory;

   // @Cacheable(key = "#userId",value = "andCache")
    public String redisSelect(String userId){

        FootService footService= (FootService)beanFactory.getBean("remoteService");
        System.out.println(footService.hello("111"));

/*        String uername=redisDao.findUserName();
        logger.info("登录者姓名 ,username:"+uername);*/
        return "成功";
    }

}
