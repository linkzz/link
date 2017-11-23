package com.link.common.kit;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * jfinal日期工具toStr方法重写
 * @author linkzz
 * @date 2017-06-02
 */
public class DateKit extends com.jfinal.ext.kit.DateKit {
    public static String toStr(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String dateToStr = sdf.format(date);
        return dateToStr;
    }
}
