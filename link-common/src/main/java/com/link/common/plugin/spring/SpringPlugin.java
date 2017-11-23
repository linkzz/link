package com.link.common.plugin.spring;

import com.jfinal.kit.PathKit;
import com.jfinal.plugin.IPlugin;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by linkzz on 2017-05-17.
 */
public class SpringPlugin implements IPlugin {
    private String[] configurations;
    private ApplicationContext ctx;

    public SpringPlugin() {
    }

    public SpringPlugin(String... configurations) {
        this.configurations = configurations;
    }

    public SpringPlugin(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public boolean start() {
        if(this.ctx != null) {
            IocInterceptor.ctx = this.ctx;
        } else if(this.configurations != null) {
            IocInterceptor.ctx = new FileSystemXmlApplicationContext(this.configurations);
        } else {
            IocInterceptor.ctx = new FileSystemXmlApplicationContext(PathKit.getWebRootPath() + "/WEB-INF/applicationContext.xml");
        }

        return true;
    }

    @Override
    public boolean stop() {
        return true;
    }
}
