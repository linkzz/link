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
 * @create 2017-12-08 17:02
 */
@Api(tag = "index", description = "测试输出")
public class IndexController extends Controller {

    @ApiOperation(url = "/test", tag = "index", httpMethod = "get", description = "测试json")
    @Params({
            @Param(name = "id", description = "编号", required = true, dataType = "Long"),
            @Param(name = "name", description = "姓名", required = true, dataType = "String")
    })

    public void test() {
        List<String> list = Arrays.asList("123","456");
        this.renderJson(list);
    }
}
