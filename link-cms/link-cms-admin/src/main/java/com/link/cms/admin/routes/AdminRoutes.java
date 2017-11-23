package com.link.cms.admin.routes;

import com.jfinal.config.Routes;
import com.link.cms.admin.controller.IndexController;
import com.link.cms.admin.controller.TopicController;

/**
  * cms后台管理系统路由
  * @author linkzz
  * @create 2017-11-23 17:24
  */
public class AdminRoutes extends Routes {
    @Override
    public void config() {
        add("/", IndexController.class);
        add("/topic", TopicController.class);
    }
}
