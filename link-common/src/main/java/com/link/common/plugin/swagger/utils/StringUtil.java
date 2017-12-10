package com.link.common.plugin.swagger.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串工具类
 *
 * @author lee
 * @date 16/6/1
 */
public class StringUtil {

    public static String SEPARATOR = String.valueOf((char) 29);

    /**
     * 判断字符串是否为空
     *
     * @param value
     * @return
     */
    public static boolean isEmpty(String value) {
        if (value != null) {
            value = value.trim();
        }
        return StringUtils.isEmpty(value);
    }

    /**
     * 判断字符串是否非空
     *
     * @param value
     * @return
     */
    public static boolean isNotEmpty(String value) {
        return !isEmpty(value);
    }

    /**
     * 拆分字符串
     *
     * @param value
     * @param regex
     * @return
     */
    public static String[] spliteString(String value, String regex) {
        String[] result = null;
        if (StringUtil.isNotEmpty(value)) {
            result = value.split(regex);
        }
        return result;
    }
}
