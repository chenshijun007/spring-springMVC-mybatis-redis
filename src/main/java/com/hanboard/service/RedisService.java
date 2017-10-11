package com.hanboard.service;

import com.alibaba.fastjson.JSON;
import com.hanboard.dao.RedisDao;


import com.hanboard.model.City;
import com.hanboard.motan.FootService;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.*;


/**
 * Created by csj on 2017/8/16.
 */
@Service
public class RedisService {
    static Logger logger =Logger.getLogger(RedisService.class);

    @Resource(name="jmsTemplate")
    private JmsTemplate jmsTemplate;

/*
   @Autowired
   RedisUtil redisUtil;*/
    @Autowired
    RedisDao redisDao;

    @Autowired
    BeanFactory beanFactory;

    @Autowired
    FootService footService;

    @Autowired
    Destination destination;

   // @Cacheable(key = "#userId",value = "andCache")
    public String redisSelect(String userId){

       /* FootService footService= (FootService)beanFactory.getBean("remoteService");
        System.out.println(footService.hello("111"));*/
/*        String uername=redisDao.findUserName();
        logger.info("登录者姓名 ,username:"+uername);*/
  //   footService.hello("11");
       //     destination=session.createQueue("haha");
        com.alibaba.fastjson.JSONObject jsonObj = new com.alibaba.fastjson.JSONObject();
        jsonObj.put("name", "张三");
        jsonObj.put("sex", "男");
        jsonObj.put("age", 20);
        String resultjson= JSON.toJSONString(jsonObj);
        sendMessage(destination,resultjson);

       // producer("test","success");
          //  receive(destination);

        return "成功";
    }


    public void sendMessage(Destination destination, final String msg){
        System.out.println("Send " + msg + " to Destination " + destination.toString());

        MessageCreator messageCreator = new MessageCreator(){

            public Message createMessage(Session session) throws JMSException {

                return session.createTextMessage(msg);
            }

        };

        jmsTemplate.send(destination, messageCreator);
    }

    public TextMessage receive(Destination destination) {
        TextMessage tm = (TextMessage) jmsTemplate.receive(destination);
        if (tm != null) {
            try {
                System.out.println("Get Message: " + tm.getText() + " from Destination " + destination.toString());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
        return tm;
    }




}
