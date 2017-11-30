package com.link.common.kit;

import com.jfinal.kit.LogKit;
import com.jfinal.kit.PropKit;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.redis.Cache;
import com.jfinal.plugin.redis.Redis;
import com.jfinal.plugin.redis.RedisPlugin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * ip地址操作
 *
 * @author linkzz
 * @create 2017-11-21 18:17
 */
public class IpKit {
    /**
     * ip 文件地址
     */
    String path;
    Cache ipsCache;

    public IpKit(String path){
        this.path = path;
        try {
            this.ipsCache = this.readFile(path);
        } catch (Exception e) {
            LogKit.info(e.getMessage());
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
         boolean result = false;
         if (StrKit.isBlank(ipSource)){
             return result;
         }else {
             result = true;
             return result;
         }
     }

    /**
     * 一行一行读取文件
     *
     * @param path
     * @return
     * @throws Exception
     */
    public Cache readFile(String path) throws IOException{
        //  用于缓存news模块的redis服务
        String ip = PropKit.get("ip");
        RedisPlugin ipsRedis = new RedisPlugin("ips", ip);
        ipsRedis.start();
        this.ipsCache = Redis.use("ips");
        try (BufferedReader br = new BufferedReader(new FileReader(this.path))){
            String line=br.readLine();
            while (line !=null) {
                this.ipsCache.set(ipToLong(line),line);
            }
        }
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
