package com.hanboard.motan;

import com.hanboard.dao.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by csj on 2017/8/24.
 */
public class FootServiceImpl implements FootService {
    @Autowired
    RedisDao redisDao;
    @Override
    public String hello(String name) {
        System.out.println(name+"实现接口ceshi");
         redisDao.findUserName();
        return "web 测试 rpc";
    }
}
