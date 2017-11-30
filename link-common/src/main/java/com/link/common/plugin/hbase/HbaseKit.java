package com.link.common.plugin.hbase;

import com.jfinal.kit.LogKit;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.client.coprocessor.AggregationClient;
import org.apache.hadoop.hbase.client.coprocessor.LongColumnInterpreter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hbase工具类
 * @author linkzz
 * @date 2017-09-22
 */
public class HbaseKit {
    private static final String AGGREGATEIMPLEMENTATIONCOPROCESSOR = "org.apache.hadoop.hbase.coprocessor.AggregateImplementation";
    protected static Connection connection;
    protected static AggregationClient aggregationClient;
    protected static LongColumnInterpreter longColumnInterpreter = new LongColumnInterpreter();

    private HbaseKit(){
        throw new IllegalStateException("HbaseKit.class");
    }

    private static Admin getAdmin(Connection connection) {
        try {
            return connection.getAdmin();
        } catch (IOException e) {
            LogKit.info(e.getMessage());
        }
        return null;
    }

    public static void createTable(String tableName, String[] familyNames) {
        Admin admin = getAdmin(connection);
        try {
            HTableDescriptor hTableDescriptor = new HTableDescriptor(TableName.valueOf(tableName));
            hTableDescriptor.addCoprocessor(AGGREGATEIMPLEMENTATIONCOPROCESSOR);
            for (String familyName : familyNames) {
                HColumnDescriptor family = new HColumnDescriptor(familyName);
                hTableDescriptor.addFamily(family);
            }
            if (admin != null){
                admin.createTable(hTableDescriptor);
            }
        } catch (IOException e) {
            LogKit.info(e.getMessage());
        } finally {
            try {
                if (admin != null){
                    admin.close();
                }
            } catch (IOException e) {
                LogKit.info(e.getMessage());
            }
        }
    }

    public static void addCoprocessor(String tableName, String className) {
        Admin admin = getAdmin(connection);
        try {
            if (admin != null){
                admin.disableTable(TableName.valueOf(tableName));
                HTableDescriptor hTableDescriptor = admin.getTableDescriptor(TableName.valueOf(tableName));
                hTableDescriptor.addCoprocessor(className);
                admin.modifyTable(TableName.valueOf(tableName), hTableDescriptor);
            }
        } catch (IOException e) {
            LogKit.info(e.getMessage());
        } finally {
            try {
                if (admin != null){
                    admin.enableTable(TableName.valueOf(tableName));
                }
            } catch (IOException e) {
                LogKit.info(e.getMessage());
            }
            try {
                if (admin != null){
                    admin.close();
                }
            } catch (IOException e) {
                LogKit.info(e.getMessage());
            }
        }
    }

    public static void deleteTable(String tableName) {
        Admin admin = getAdmin(connection);
        try {
            if (admin != null){
                admin.disableTable(TableName.valueOf(tableName));
                admin.deleteTable(TableName.valueOf(tableName));
            }
        } catch (IOException e) {
            LogKit.info(e.getMessage());
        } finally {
            try {
                if (admin != null){
                    admin.close();
                }
            } catch (IOException e) {
                LogKit.info(e.getMessage());
            }
        }
    }

    public static HTableDescriptor tableDescriptor(String tableName) {
        Admin admin = getAdmin(connection);
        HTableDescriptor desc = null;
        Table table = null;
        try {
            table = connection.getTable(TableName.valueOf(tableName));
            desc = table.getTableDescriptor();
        } catch (IOException e) {
            LogKit.info(e.getMessage());
        } finally {
            try {
                if (admin != null){
                    admin.close();
                }
            } catch (IOException e) {
                LogKit.info(e.getMessage());
            }
            try {
                if (admin != null){
                    admin.close();
                }
            } catch (IOException e) {
                LogKit.info(e.getMessage());
            }
        }
        return desc;
    }

    public static void put(String tableName, Put put) {
        put(tableName, Arrays.asList(put));
    }

    public static void put(String tableName, List<Put> puts) {
        Table table = null;
        try {
            table = connection.getTable(TableName.valueOf(tableName));
            table.put(puts);
        } catch (IOException e) {
            LogKit.info(e.getMessage());
        } finally {
            try {
                if (table != null){
                    table.close();
                }
            } catch (IOException e) {
                LogKit.info(e.getMessage());
            }
        }
    }

    public static List<Result> scan(String tableName) {
        return scan(tableName, new Scan());
    }

    public static List<Result> scan(String tableName, Integer pageSize) {
        return scan(tableName, new Scan(), pageSize);
    }

    public static List<Result> scan(String tableName, Scan scan) {
        return scan(tableName, scan, null);
    }

    public static List<Result> scan(String tableName, Scan scan, Integer pageSize) {
        List<Result> results = new ArrayList<>();
        ResultScanner resultScanner = null;
        Table table = null;
        try {
            table = connection.getTable(TableName.valueOf(tableName));
            resultScanner = table.getScanner(scan);
            if (pageSize != null) {
                Result[] rs = resultScanner.next(pageSize);
                for (Result result : rs) {
                    results.add(result);
                }
            } else {
                for (Result result : resultScanner) {
                    results.add(result);
                }
            }
        } catch (IOException e) {
            LogKit.info(e.getMessage());
        } finally {
            if (resultScanner != null) {
                resultScanner.close();
            }
            try {
                if (table != null){
                    table.close();
                }
            } catch (IOException e) {
                LogKit.info(e.getMessage());
            }
        }
        return results;
    }

    public static void delete(String tableName, Delete del) {
        Table table = null;
        try {
            table = connection.getTable(TableName.valueOf(tableName));
            table.delete(del);
        } catch (IOException e) {
            LogKit.info(e.getMessage());
        } finally {
            try {
                if (table != null){
                    table.close();
                }
            } catch (IOException e) {
                LogKit.info(e.getMessage());
            }
        }
    }

    public static Result get(String tableName, Get g) {
        Result[] result = get(tableName, Arrays.asList(g));
        if (result != null && result.length > 0) {
            return result[0];
        }
        return null;
    }

    public static Result[] get(String tableName, List<Get> gets) {
        Table table = null;
        try {
            table = connection.getTable(TableName.valueOf(tableName));
            return table.get(gets);
        } catch (IOException e) {
            LogKit.info(e.getMessage());
        } finally {
            try {
                if (table != null){
                    table.close();
                }
            } catch (IOException e) {
                LogKit.info(e.getMessage());
            }
        }
        return new Result[0];
    }

    public static long rowCount(String tableName, Scan scan) {
        try {
            return aggregationClient.rowCount(TableName.valueOf(tableName), longColumnInterpreter, scan);
        } catch (Throwable e) {
            LogKit.info(e.getMessage());
        }
        return 0;
    }
}
