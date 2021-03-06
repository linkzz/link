package com.link.cms.common.common;

/**
 * 结果返回枚举
 *
 * @author linkzz
 * @create 2017-11-14 19:35
 */
public enum CmsResultConstant {

    /**
     * 失败
     */
    FAILED(0, "failed"),

    /**
     * 成功
     */
    SUCCESS(1, "success"),

    /**
     * 文件类型不支持
     */
    FILE_TYPE_ERROR(20001, "File type not supported!"),

    /**
     * 无效长度
     */
    INVALID_LENGTH(20002, "Invalid length"),

    /**
     * 无效参数
     */
    INVALID_PARAMETER(20003, "Invalid parameter");

    private int code;

    private String message;

    CmsResultConstant(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
