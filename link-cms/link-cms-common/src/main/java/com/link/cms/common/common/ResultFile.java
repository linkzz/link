package com.link.cms.common.common;

/**
 * 文件上传结果返回
 * @author linkzz
 * @date 2017-07-13
 */
public class ResultFile {
    private int error;
    private String url;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
