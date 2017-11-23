package com.link.common.kit;

import com.jfinal.plugin.redis.Cache;
import com.jfinal.plugin.redis.Redis;
import com.jfinal.plugin.redis.RedisPlugin;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * ip地址操作
 *
 * @author linkzz
 * @create 2017-11-21 18:17
 */
public class IpKit {

    Cache ipsCache;

    public IpKit(){
        /**
         * ip 文件地址
         */
        String path = "C:/Users/chenxun/Desktop/ip.txt";
        try {
            this.ipsCache = this.readFile(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     /**
      * 判断指定的ipv4地址是否在当前名单中
      * 
      * @param ip
      *            指定的ip地址值(v4)
      * @return true: 在名单中， false: 不在名单中
      */

     public boolean isInList(String ip){
         String ipSource = this.ipsCache.get(ipToLong(ip));
         if (StrKit.isBlank(ipSource)){
             return false;
         }else {
             return true;
         }
     }

    /**
     * 一行一行读取文件
     *
     * @param path
     * @return
     * @throws Exception
     */
    public Cache readFile(String path) throws Exception{
        //  用于缓存news模块的redis服务
        RedisPlugin ipsRedis = new RedisPlugin("ips", "192.168.3.9");
        ipsRedis.start();
        this.ipsCache = Redis.use("ips");
        FileReader fr=new FileReader(path);
        BufferedReader br=new BufferedReader(fr);
        String line=null;
        while ((line=br.readLine())!=null) {
            this.ipsCache.set(ipToLong(line),line);
        }
        br.close();
        fr.close();
        return this.ipsCache;
    }

    /**
     * @Description: ip地址转换为long类型字符串
     * @author: linkzz
     * @data: 2017-09-13 10:42
     */
    public static long ipToLong(String ipAddress){
        String[] ipAddressInArray = ipAddress.split("\\.");
        long result = 0;
        for (int i = 0; i < ipAddressInArray.length; i++){
            int power = 3-i;
            int ip = Integer.parseInt(ipAddressInArray[i]);
            result += ip * Math.pow(256,power);
        }
        return result;
    }

}
