package com.link.common.plugin.activemq;

import com.jfinal.kit.LogKit;
import com.jfinal.plugin.IPlugin;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.pool.PooledConnection;
import org.apache.activemq.pool.PooledConnectionFactory;

import javax.jms.JMSException;

/**
 * activeMQ插件
 *
 * @author linkzz
 * @create 2017-11-23 9:27
 */
public class ActiveMQPlugin implements IPlugin {
    private String url;
    private String name;

    public ActiveMQPlugin(String url, String name) {
        this.url = url;
        this.name = name;
    }
    public ActiveMQPlugin(String url) {
        this.url = url;
        this.name = ActiveMQKit.DEFAULTNAME;
    }

    @Override
    public boolean start() {
        LogKit.info("启动activemq插件并初始化activeMQ配置");
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setUserName(ActiveMQConnection.DEFAULT_USER);
        activeMQConnectionFactory.setPassword(ActiveMQConnection.DEFAULT_PASSWORD);
        activeMQConnectionFactory.setBrokerURL(url);
        //异步发送消息
        activeMQConnectionFactory.setDispatchAsync(true);
        PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory(activeMQConnectionFactory);
        pooledConnectionFactory.setMaximumActiveSessionPerConnection(200);
        pooledConnectionFactory.setIdleTimeout(120);
        pooledConnectionFactory.setMaxConnections(5);
        pooledConnectionFactory.setBlockIfSessionPoolIsFull(true);
        try {
            PooledConnection connection = (PooledConnection) pooledConnectionFactory.createConnection();
            connection.start();
            ActiveMQKit.POOLEDCONNECTIONMAP.put(name, connection);
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean stop() {
        return true;
    }
}
