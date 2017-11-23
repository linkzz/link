package com.link.cms.admin.test;

import com.link.cms.rpc.api.TopicServiceI;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDubboConsumer {

    @Test
    public void testDubbC(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"META-INF/spring/applicationContext-dubbo-consumer.xml"});
        context.start();
        TopicServiceI topicService = (TopicServiceI) context.getBean("topicService"); // obtain proxy object for remote invocation
        String hello = topicService.sysHello("world"); // execute remote invocation
        System.out.println("客户端打印："+hello); // show the result
    }
}
