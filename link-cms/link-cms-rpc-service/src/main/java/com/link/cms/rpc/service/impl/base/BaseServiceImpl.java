package com.link.cms.rpc.service.impl.base;

import com.jfinal.plugin.activerecord.Model;
import com.link.cms.common.common.ResultJson;
import com.link.cms.common.jqgrid.DataGrid;
import com.link.cms.common.jqgrid.JqGrid;
import com.link.cms.rpc.api.base.BaseServiceI;

/**
 * 公共方法服务
 *
 * @author linkzz
 * @create 2017-11-21 11:35
 */
public class BaseServiceImpl implements BaseServiceI {
    /**
     * @param jqGrid jqGrid 封装的参数
     * @param model  模型参数
     * @param table  操作的表
     * @Description: 封装数据表格
     * @author: linkzz
     * @data: 2017-05-07 0:10
     */
    @Override
    public DataGrid dataGrid(JqGrid jqGrid, Model model, String table) {
        return null;
    }

    /**
     * @param jqGrid
     * @param model
     * @param table  @return
     * @Description:
     * @author: linkzz
     * @data: 2017-10-26 15:53
     */
    @Override
    public DataGrid treeDataGrid(JqGrid jqGrid, Model model, String table) {
        return null;
    }

    /**
     * @param model  模型参数
     * @param id     当前更新操作的id
     * @param table  操作的表
     * @param jqGrid jqGrid 封装的参数
     * @Description: 增删改一起做
     * @author: linkzz
     * @data: 2017-06-02 13:08
     */
    @Override
    public ResultJson saveOrUpdate(Model model, String id, String table, JqGrid jqGrid) {
        return null;
    }
}
