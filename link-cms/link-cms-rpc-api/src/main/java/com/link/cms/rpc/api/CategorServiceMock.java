package com.link.cms.rpc.api;

import com.jfinal.plugin.activerecord.Model;
import com.link.cms.common.common.ResultJson;
import com.link.cms.common.jqgrid.DataGrid;
import com.link.cms.common.jqgrid.JqGrid;

/**
 * 频道降级服务
 * @author linkzz
 * @create 2017-11-29 15:21
 */
public class CategorServiceMock implements CategorServiceI {
    @Override
    public DataGrid dataGrid(JqGrid jqGrid, Model model, String table) {
        return null;
    }

    @Override
    public DataGrid treeDataGrid(JqGrid jqGrid, Model model, String table) {
        return null;
    }

    @Override
    public ResultJson saveOrUpdate(Model model, String id, String table, JqGrid jqGrid) {
        return null;
    }
}
