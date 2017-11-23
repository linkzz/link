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
    public static final String defaultName = "main";
    public static final ConcurrentHashMap<String, PooledConnection> pooledConnectionMap = new ConcurrentHashMap<>();
    public static final ConcurrentHashMap<String, JmsSender> senderMap = new ConcurrentHashMap<>();
    public static final ConcurrentHashMap<String, JmsReceiver> receiverMap = new ConcurrentHashMap<>();

    public static void addSender(JmsSender sender) {
        senderMap.put(sender.getName(), sender);
    }

    public static JmsSender getSender(String name) {
        return senderMap.get(name);
    }

    public static void addReceiver(JmsReceiver receiver) {
        receiverMap.put(receiver.getName(), receiver);
    }
    public static JmsReceiver getReceiver(String name) {
        return receiverMap.get(name);
    }

    public static void addConnection(String connectionName, PooledConnection connection) {
        pooledConnectionMap.put(connectionName, connection);
    }
    public static PooledConnection getConnection() {
        return pooledConnectionMap.get(defaultName);
    }
    public static PooledConnection getConnection(String connectionName) {
        return pooledConnectionMap.get(connectionName);
    }
}
