package com.link.common.kit;

/**
 * @ClassName: ConvertKit
 * @Description: 各种转换工具类
 * @author: linkzz
 * @data: 2017-06-28 11:34
*/
public class ConvertKit {
    /**
     * @Description: boolean 值和 0/1的转换
     * @author: linkzz
     * @data: 2017-06-14 15:15
    */
    public static int convert(boolean value){
        if(value) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * @Description: 获取IP地址
     * @author: linkzz
     * @data: 2017-06-14 15:15
    */
    public static String getRemoteHost(javax.servlet.http.HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ?"127.0.0.1":ip;
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
