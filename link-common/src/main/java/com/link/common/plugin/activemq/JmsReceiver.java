package com.link.common.plugin.activemq;

import com.jfinal.kit.LogKit;
import org.apache.activemq.pool.PooledConnection;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.jms.*;
import java.util.Enumeration;

/**
 * 消息消费者
 *
 * @author linkzz
 * @create 2017-11-23 9:21
 */
public class JmsReceiver implements MessageListener {
    private String name;
    private Session session;
    private MessageConsumer consumer;
    ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
    /**
     * @Description: 初始化消息消费者
     * @author: linkzz
     * @data: 2017-11-23 9:25
    */
    public JmsReceiver(String name, PooledConnection connection, Destination type, String subject) throws JMSException {
        this.name = name;
        // 事务性会话，自动确认消息
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 消息的目的地（Queue/Topic）
        if (type.equals(Destination.TOPIC)) {
            Topic destination = session.createTopic(subject);
            consumer = session.createConsumer(destination);
        } else {
            Queue destination = session.createQueue(subject);
            consumer = session.createConsumer(destination);
        }
        consumer.setMessageListener(this);
    }

    @Override
    public void onMessage(Message message) {
        /**
         * 使用线程池多线程处理
         */
        threadPoolTaskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    if (message instanceof TextMessage) {
                        TextMessage msg = (TextMessage) message;
                        LogKit.info(msg.getText());
                    } else if (message instanceof MapMessage) {
                        MapMessage msg = (MapMessage) message;
                        Enumeration enumer = msg.getMapNames();
                        while (enumer.hasMoreElements()) {
                            Object obj = enumer.nextElement();
                            LogKit.info(msg.getObject(obj.toString()).toString());
                        }
                    } else if (message instanceof StreamMessage) {
                        StreamMessage msg = (StreamMessage) message;
                        LogKit.info(msg.readString());
                        LogKit.info(String.valueOf(msg.readBoolean()));
                        LogKit.info(String.valueOf(msg.readLong()));
                    } else if (message instanceof ObjectMessage) {
                        ObjectMessage msg = (ObjectMessage) message;
                        LogKit.info(msg.toString());
                    } else if (message instanceof BytesMessage) {
                        BytesMessage msg = (BytesMessage) message;
                        byte[] byteContent = new byte[1024];
                        int length = -1;
                        StringBuilder content = new StringBuilder();
                        while ((length = msg.readBytes(byteContent)) != -1) {
                            content.append(new String(byteContent, 0, length));
                        }
                        LogKit.info(content.toString());
                    } else {
                        LogKit.info(message.toString());
                    }
                } catch (Exception e) {
                    LogKit.info(e.getMessage());
                }
            }
        });
    }

    public String getName() {
        return name;
    }
}
