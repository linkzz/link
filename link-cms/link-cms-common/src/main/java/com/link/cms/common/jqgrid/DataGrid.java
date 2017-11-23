package com.link.cms.common.jqgrid;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:DataGrid
 * @Description:封装jqgrid数据集合
 * @author:linkzz
 * @data:2017-05-06 19:25
*/
public class DataGrid{
    private int total = 0;
    private int page = 0;
    private int records = 0;
    private List rows = new ArrayList();

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRecords() {
        return records;
    }

    public void setRecords(int records) {
        this.records = records;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
