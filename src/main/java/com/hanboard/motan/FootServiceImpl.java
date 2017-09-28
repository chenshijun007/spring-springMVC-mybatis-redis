package com.hanboard.motan;

import com.weibo.api.motan.config.springsupport.annotation.MotanService;

/**
 * Created by csj on 2017/8/24.
 */
public class FootServiceImpl {
    public String hello(String name) {
        System.out.println(name+"实现接口");
        return "web 测试 rpc";
    }
}
