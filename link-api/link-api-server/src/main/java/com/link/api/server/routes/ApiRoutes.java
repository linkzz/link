package com.link.api.server.routes;

import com.jfinal.config.Routes;
import com.link.api.server.controller.ApiController;
import com.link.api.server.controller.IndexController;
import com.link.api.server.controller.OrderController;

/**
 * @author linkzz
 * @create 2017-12-08 15:18
 */
public class ApiRoutes extends Routes {
    @Override
    public void config() {
        setBaseViewPath("/view");
        add("/api", ApiController.class);
        add("/", IndexController.class);
        add("/order", OrderController.class);
    }
}
