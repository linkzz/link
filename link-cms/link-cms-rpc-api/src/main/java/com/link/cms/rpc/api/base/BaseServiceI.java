package com.link.cms.rpc.api.base;

import com.jfinal.plugin.activerecord.Model;
import com.link.cms.common.common.ResultJson;
import com.link.cms.common.jqgrid.DataGrid;
import com.link.cms.common.jqgrid.JqGrid;

/**
 * @ClassName: BaseServiceI
 * @Description: 接口公共方法
 * @author: linkzz
 * @data: 2017-10-26 14:49
*/
public interface BaseServiceI {
    /**
     * @Description: 封装数据表格
     * @author: linkzz
     * @param jqGrid jqGrid 封装的参数
     * @param model 模型参数
     * @param table 操作的表
     * @return DataGrid 数据表格封装
     * @data: 2017-05-07 0:10
     */
    DataGrid dataGrid(JqGrid jqGrid, Model model, String table);

    /**
     * @Description: 封装treeGrid数据
     * @author: linkzz
     * @param jqGrid jqGrid 封装的参数
     * @param model 模型参数
     * @param table 操作的表
     * @data: 2017-06-06 9:27
    */
    /**
     * @Description:
     * @author: linkzz
     * @param
     * @return
     * @data: 2017-10-26 15:53
    */
    DataGrid treeDataGrid(JqGrid jqGrid, Model model, String table);

    /**
     * @Description: 增删改一起做
     * @author: linkzz
     * @param jqGrid jqGrid 封装的参数
     * @param model 模型参数
     * @param table 操作的表
     * @param id 当前更新操作的id
     * @data: 2017-06-02 13:08
     */
    ResultJson saveOrUpdate(Model model, String id, String table, JqGrid jqGrid);

}
