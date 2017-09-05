package com.hanboard.motan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by csj on 2017/8/24.
 */
public class Client {
    public static void main(String[] args) {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:motan/motan-client.xml");

    }
}
