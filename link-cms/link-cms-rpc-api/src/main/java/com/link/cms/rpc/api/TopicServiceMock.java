package com.link.cms.rpc.api;

import com.jfinal.plugin.activerecord.Model;
import com.link.cms.common.common.ResultJson;
import com.link.cms.common.jqgrid.DataGrid;
import com.link.cms.common.jqgrid.JqGrid;
import com.link.cms.model.Topic;

/**
 * 专题服务降级处理
 * @author linkzz
 * @create 2017-11-23 18:41
 */
public class TopicServiceMock implements TopicServiceI {
    @Override
    public ResultJson save(Topic model) {
        return null;
    }

    @Override
    public Topic getTopicById(String id) {
        return null;
    }

    @Override
    public String sysHello(String name) {
        return null;
    }

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
