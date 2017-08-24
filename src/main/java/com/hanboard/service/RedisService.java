package com.hanboard.service;

import com.hanboard.dao.RedisDao;


import com.hanboard.model.City;
import com.hanboard.util.RedisUtil;
import com.hanboard.utils.RedisUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;


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
   // @Cacheable(key = "#userId",value = "andCache")
    public String redisSelect(String userId){
     /* ValueOperations valueOperations= template.opsForValue();
      valueOperations.set("City","chengdu",30, TimeUtil.SECONDS);*/
        // redisUtil.saveCacheString("121","rfasfkasfh",300);
        //  redisUtil.delCacheString("121");
        //  redisUtil.cacheList("11","asdads",300);
      //  RedisUtil.redisInstance().deleteCache("City");

   //    RedisUtil.saveCache("zhongguo:chengdu:shuangliu","hello");
  //    String str=   RedisUtil.getCache("zhongguo:chengdu:shuangliu");
        List<City> cities=redisDao.findAllCity();
        City city=cities.get(0);
     //   RedisUtils.redisInstance().saveCache("11",city,30, TimeUnit.SECONDS);
     //  RedisUtil.redisInstance().saveCache("City",cities);
      //  RedisUtils.saveCacheString("jar","11",30);
      /* City c=RedisUtil.redisInstance().getCache("11",City.class);
        if (c!=null){
            System.out.println(c.toString());
        }*/
        String uername=redisDao.findUserName();
        logger.info("登录者姓名 ,username:"+uername);
        return uername;
    }

}
