package com.link.common.plugin.hbase;

import com.jfinal.kit.LogKit;
import com.jfinal.plugin.IPlugin;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.coprocessor.AggregationClient;

import java.io.IOException;

/**
 * Hbase 插件
 * @author linkzz
 * @date 2017-09-22
 */
public class HbasePlugin implements IPlugin {
    private String quorum;
    private String znode = "/hbase";
    private String encoding = "UTF-8";
    public HbasePlugin(String quorum) {
        this.quorum = quorum;
    }

    @Override
    public boolean start() {
        Configuration config = HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum", quorum);
        config.set("hbase.zookeeper.znode.parent", znode);
        config.set("hbase.encoding", encoding);
        try {
            HbaseKit.connection = ConnectionFactory.createConnection(config);
        } catch (IOException e) {
            LogKit.info(e.getMessage());
        }
        HbaseKit.aggregationClient = new AggregationClient(config);
        return true;
    }

    @Override
    public boolean stop() {
        if (!HbaseKit.connection.isClosed()) {
            try {
                HbaseKit.connection.close();
            } catch (IOException e) {
                LogKit.info(e.getMessage());
            }
        }
        try {
            HbaseKit.aggregationClient.close();
        } catch (IOException e) {
            LogKit.info(e.getMessage());
        }
        return true;
    }
}
