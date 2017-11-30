package com.link.common.plugin.activemq;

import org.apache.activemq.pool.PooledConnection;

import javax.jms.*;

/**
 * 消息发送者
 *
 * @author linkzz
 * @create 2017-11-23 8:40
 */
public class JmsSender {

    private String name;
    private Session session;
    private MessageProducer producer;

    /**
     * @Description: 初始化消息发送者
     * @author: linkzz
     * @data: 2017-11-23 9:18
    */
    public JmsSender(String name, PooledConnection connection, Destination type, String subject) throws JMSException{
        this.name = name;
        // 事务性会话，自动确认消息
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 消息的目的地（Queue/Topic）
        if (type.equals(Destination.TOPIC)) {
            Topic destination = session.createTopic(subject);
            producer = session.createProducer(destination);
        } else {
            Queue destination = session.createQueue(subject);
            producer = session.createProducer(destination);
        }
        // 不持久化消息
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
    }

    /**
     * @Description: 发送消息
     * @author: linkzz
     * @param message||Message|必填
     * @return
     * @data: 2017-11-23 9:18
    */
    public void sendMessage(Message message) throws JMSException{
        producer.send(message);
    }

    public String getName() {
        return name;
    }

    public Session getSession() {
        return session;
    }
}
