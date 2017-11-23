package com.link.cms.admin.config;

import com.jfinal.config.*;
import com.jfinal.kit.PathKit;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import com.link.cms.admin.routes.AdminRoutes;
import com.link.common.plugin.spring.IocInterceptor;
import com.link.common.plugin.spring.SpringPlugin;

/**
 * cms系统后台配置
 *
 * @author linkzz
 * @create 2017-11-23 17:21
 */
public class AdminConfig extends JFinalConfig{
    @Override
    public void configConstant(Constants constants) {
        constants.setViewType(ViewType.JFINAL_TEMPLATE);
    }

    @Override
    public void configRoute(Routes routes) {
        routes.add(new AdminRoutes());
    }

    @Override
    public void configEngine(Engine engine) {

    }

    @Override
    public void configPlugin(Plugins plugins) {
        plugins.add(new SpringPlugin(PathKit.getWebRootPath() + "/WEB-INF/classes/META-INF/spring/applicationContext-dubbo-consumer.xml"));
    }

    @Override
    public void configInterceptor(Interceptors interceptors) {
        interceptors.addGlobalActionInterceptor(new IocInterceptor());
    }

    @Override
    public void configHandler(Handlers handlers) {

    }
}
