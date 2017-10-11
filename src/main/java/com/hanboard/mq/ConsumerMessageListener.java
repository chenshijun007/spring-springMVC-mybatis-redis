package com.hanboard.mq;

import com.hanboard.dao.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by csj on 2017/10/10.
 */
@Component("consumerMessageListener")
public class ConsumerMessageListener implements MessageListener {

    @Autowired
    RedisDao redisDao;
    @Override
    public void onMessage(Message message) {
        try {
            TextMessage textMsg = (TextMessage) message;
            System.out.println("监听消息接收到一个纯文本消息。"+textMsg.getText());
            redisDao.findAllCity();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
