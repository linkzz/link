package com.link.api.server.controller;

import com.jfinal.core.Controller;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Arrays;
import java.util.List;

/**
 * @author linkzz
 * @create 2017-12-08 17:03
 */
@Api(value = "test", description = "test")
public class OrderController extends Controller {
    @ApiOperation(value = "test",notes = "获取数据", produces = "application/json")
    public void find(String orderId) {
        List<String> list = Arrays.asList("123",orderId);
        this.renderJson(list);
    }

    public void login() {
        List<String> list = Arrays.asList("123","456");
        this.renderJson(list);
    }
}
