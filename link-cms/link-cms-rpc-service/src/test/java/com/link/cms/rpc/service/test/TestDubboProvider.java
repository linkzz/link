package com.link.cms.rpc.service.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class TestDubboProvider {

    @Test
    public void testDubboP(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {"META-INF/spring/applicationContext-dubbo-provider.xml"});
        context.start();
        try {
            System.in.read(); // press any key to exit
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
