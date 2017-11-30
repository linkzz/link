package com.link.commom.test;

import com.link.common.plugin.activemq.*;
import org.junit.Test;

import javax.jms.JMSException;
import javax.jms.TextMessage;
import java.util.Date;

/**
 * 测试activemq
 *
 * @author linkzz
 * @create 2017-11-23 9:55
 */
public class TestActiveMQPlugin {

    @Test
    public void testActiveMQ() throws JMSException {
        ActiveMQPlugin p = new ActiveMQPlugin("failover://(tcp://192.168.5.140:61616)?initialReconnectDelay=1000");
        p.start();
        String subject = "测试消息发送";
        //定义发送者
        ActiveMQKit.addSender(new JmsSender("testsender1",ActiveMQKit.getConnection(), Destination.QUEUE,subject));
        //定义接受者
        ActiveMQKit.addReceiver(new JmsReceiver("testReceiver1",ActiveMQKit.getConnection(),Destination.QUEUE,subject));
        for (int i = 0; i < 10; i++){
            new Runnable(){

                /**
                 * When an object implementing interface <code>Runnable</code> is used
                 * to create a thread, starting the thread causes the object's
                 * <code>run</code> method to be called in that separately executing
                 * thread.
                 * <p>
                 * The general contract of the method <code>run</code> is that it may
                 * take any action whatsoever.
                 *
                 * @see Thread#run()
                 */
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        JmsSender sq1 = ActiveMQKit.getSender("testSender1");
                        TextMessage msg = sq1.getSession().createTextMessage("测试" + new Date());
                        sq1.sendMessage(msg);
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            }.run();
        }
    }
}
