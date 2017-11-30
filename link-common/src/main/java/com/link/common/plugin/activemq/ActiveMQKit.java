package com.link.common.plugin.activemq;

import org.apache.activemq.pool.PooledConnection;

import java.util.concurrent.ConcurrentHashMap;

/**
 * ActiveMQ工具类
 *
 * @author linkzz
 * @create 2017-11-23 9:38
 */
public class ActiveMQKit {
    protected static final String DEFAULTNAME = "main";
    protected static final ConcurrentHashMap<String, PooledConnection> POOLEDCONNECTIONMAP = new ConcurrentHashMap<>();
    protected static final ConcurrentHashMap<String, JmsSender> SENDERMAP = new ConcurrentHashMap<>();
    protected static final ConcurrentHashMap<String, JmsReceiver> RECEIVERMAP = new ConcurrentHashMap<>();

    private ActiveMQKit(){
        throw new IllegalStateException("ActiveMQKit.class");
    }
    public static void addSender(JmsSender sender) {
        SENDERMAP.put(sender.getName(), sender);
    }

    public static JmsSender getSender(String name) {
        return SENDERMAP.get(name);
    }

    public static void addReceiver(JmsReceiver receiver) {
        RECEIVERMAP.put(receiver.getName(), receiver);
    }
    public static JmsReceiver getReceiver(String name) {
        return RECEIVERMAP.get(name);
    }

    public static void addConnection(String connectionName, PooledConnection connection) {
        POOLEDCONNECTIONMAP.put(connectionName, connection);
    }
    public static PooledConnection getConnection() {
        return POOLEDCONNECTIONMAP.get(DEFAULTNAME);
    }
    public static PooledConnection getConnection(String connectionName) {
        return POOLEDCONNECTIONMAP.get(connectionName);
    }
}
