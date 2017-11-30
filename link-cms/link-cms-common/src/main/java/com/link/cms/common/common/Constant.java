package com.link.cms.common.common;

/**
 * @ClassName: Constant
 * @Description: 页面返回结果全局常量
 * @author: linkzz
 * @data: 2017-05-08 16:08
*/
public class Constant {
    private Constant(){
        throw new IllegalStateException("Constant.class");
    }
    /**
     * 页面结果返回成功
     */
    public static final String RESULT_SUCCESS = "0000";
    /**
     *页面结果返回数据库操作异常！
     */
    public static final String RESULT_SQL_ERROR = "0001";
    /**
     * 请求超时
     */
    public static final String RESULT_OUT_TIME = "0002";
    /**
     * 禁止访问，未授权
     */
    public static final String RESULT_FORBIDDEN= "0003";

    //登录返回码
    /**
     * 账号不存在
     */
    public static final String RESULT_LOGIN_ACC_NOT_EXISTENT = "1000";
    /**
     * 账号未启用
     */
    public static final String RESULT_LOGIN_DISABLE = "1001";
    /**
     * 密码错误
     */
    public static final String RESULT_LOGIN_ERROR = "1003";
    /**
     * 未知错误
     */
    public static final String RESULT_LOGIN_NUKOWN = "1004";
    /**
     * 未授权
     */
    public static final String ERROR401PATH = "401.html";
    /**
     * 找不到
     */
    public static final String ERROR404PATH = "404.html";
    /**
     * 服务器异常
     */
    public static final String ERROR500PATH = "500.html";
    /**
     * 禁止访问
     */
    public static final String ERROR403PATH = "403.html";

}
