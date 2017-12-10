package com.link.api.server.controller;

import com.jfinal.core.Controller;
import com.link.common.plugin.swagger.annotation.Api;
import com.link.common.plugin.swagger.annotation.ApiOperation;
import com.link.common.plugin.swagger.annotation.Param;
import com.link.common.plugin.swagger.annotation.Params;

import java.util.Arrays;
import java.util.List;

/**
 * @author linkzz
 * @create 2017-12-08 17:03
 */
@Api(tag = "order", description = "order测试")
public class OrderController extends Controller {

    @ApiOperation(url = "/order/find", tag = "order", httpMethod = "get", description = "查找订单")
    @Params({
            @Param(name = "id", description = "编号", required = true, dataType = "Long"),
            @Param(name = "name", description = "姓名", required = true, dataType = "String")
    })
    public void find() {
        List<String> list = Arrays.asList("123","456");
        this.renderJson(list);
    }

    @ApiOperation(url = "/order/login", tag = "order", httpMethod = "post", description = "登录")
    @Params({
            @Param(name = "id", description = "编号", required = true, dataType = "String"),
            @Param(name = "name", description = "姓名", required = true, dataType = "String")
    })
    public void login() {
        List<String> list = Arrays.asList("123","456");
        this.renderJson(list);
    }
}
