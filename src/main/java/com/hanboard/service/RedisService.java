package com.hanboard.service;


import com.hanboard.dao.mysql.RedisDao;
import com.hanboard.dao.mysql1.TestTransDao;
import com.hanboard.dao.oracle.RedisOracleDao;
import com.hanboard.model.City;

import com.hanboard.motan.FootService;
import com.hanboard.redis.util.RedisUtils;
import com.hanboard.util.RedisUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



/**
 * Created by csj on 2017/8/16.
 */
@Service
public class RedisService {
    static Logger logger =Logger.getLogger(RedisService.class);


    @Autowired
    RedisDao redisMysqlDao;

    @Autowired
    TestTransDao testTransDao;

    @Autowired
    private BeanFactory beanFactory;


 //  @Cacheable(key = "#userId",value = "andCache")
    public List<City> redisSelect(String userId){
   /*  FootService footService= (FootService)beanFactory.getBean("remoteServer");
        System.out.println(footService.hello("111"));*/

     /* ValueOperations valueOperations= template.opsForValue();
      valueOperations.set("City","chengdu",30, TimeUtil.SECONDS);*/
        // redisUtil.saveCacheString("121","rfasfkasfh",300);
        //  redisUtil.delCacheString("121");
        //  redisUtil.cacheList("11","asdads",300);
      //  RedisUtil.redisInstance().deleteCache("City");

   //    RedisUtil.saveCache("zhongguo:chengdu:shuangliu","hello");
  //    String str=   RedisUtil.getCache("zhongguo:chengdu:shuangliu");
     //  List<City> cities=redisDao.findAllCity();
      //  City city=cities.get(0);
     //   RedisUtils.redisInstance().saveCache("11",city,30, TimeUnit.SECONDS);
     //  RedisUtil.redisInstance().saveCache("City",cities);
        RedisUtil.saveCache("system",111);
       String str=RedisUtil.getCache("111");
        System.out.println("取值:"+str);
        Boolean flag=RedisUtil.isExists("system");
        System.out.println(flag);
      /* City c=RedisUtil.redisInstance().getCache("11",City.class);
        if (c!=null){
            System.out.println(c.toString());
        }*/
     //   System.out.println(helloResource.testPrimitiveType());
     /*  HelloResource helloResource= (HelloResource) beanFactory.getBean("restfulReferer");
        System.out.println("resful协议："+helloResource.testPrimitiveType());
*/

     /*  List<City> list=redisMysqlDao.findAllCity();
        System.out.println(list.get(0).toString());*/
  /*     List<City> list1=redisOracleDao.findAllCity();
        System.out.println(list1.get(0).toString());*/
    //    String uername=redisDao.findUserName();
     //   logger.info("登录者姓名 ,username:"+uername);
        return null;
    }


    public void updateTrans(){
      //  FootService footService= (FootService)beanFactory.getBean("remoteService");
      //  System.out.println(footService.hello("111"));
        testTransDao.updateUserName();
        redisMysqlDao.updateUserName();
       System.out.println(redisMysqlDao.findAllCity());

    /*
        redisMysqlDao.updateUserName();
      System.out.println(redisMysqlDao.findAllCity());*/
    }

}
