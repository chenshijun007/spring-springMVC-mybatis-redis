package com.hanboard.controller;

import com.hanboard.model.City;
import com.hanboard.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by csj on 2017/8/16.
 */
@Controller
@RequestMapping("redis")
public class RedisController {

    @Autowired
    RedisService redisService;


    @RequestMapping(value = "select",method = RequestMethod.GET)
    @ResponseBody
    public List<City> redisSelect(){
        String id="1111";
      return  redisService.redisSelect(id);
    }
}
