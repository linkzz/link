package com.link.api.server.controller;

import com.jfinal.core.Controller;
import java.util.Arrays;
import java.util.List;

/**
 * @author linkzz
 * @create 2017-12-08 17:02
 */
public class IndexController extends Controller {

    public void index(){
        render("common/index.html");
    }

    public void test(String id,String name) {
        List<String> list = Arrays.asList("123","456");
        renderJson(list);
    }
}
