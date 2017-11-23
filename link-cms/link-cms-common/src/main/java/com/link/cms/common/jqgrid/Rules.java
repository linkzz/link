package com.link.cms.common.jqgrid;

/**
 * 查询规则
 * @author linkzz
 * @date 2017-05-12
 */
public class Rules {
    public String field;
    public String op;
    public String data;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
