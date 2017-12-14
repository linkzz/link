package com.link.api.server.config;

import com.jfinal.config.*;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import com.link.api.server.routes.ApiRoutes;

/**
 * @author linkzz
 * @create 2017-12-08 16:17
 */
public class Apiconfig extends JFinalConfig {
    @Override
    public void configConstant(Constants constants) {
        constants.setViewType(ViewType.JFINAL_TEMPLATE);
    }

    @Override
    public void configRoute(Routes routes) {
        routes.add(new ApiRoutes());
    }

    @Override
    public void configEngine(Engine engine) {

    }

    @Override
    public void configPlugin(Plugins plugins) {

    }

    @Override
    public void configInterceptor(Interceptors interceptors) {

    }

    @Override
    public void configHandler(Handlers handlers) {
        handlers.add(new ContextPathHandler("ctx"));
    }
}
