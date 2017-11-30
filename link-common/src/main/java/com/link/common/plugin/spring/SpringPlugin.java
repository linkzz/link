package com.link.common.plugin.spring;

import com.jfinal.kit.PathKit;
import com.jfinal.plugin.IPlugin;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * spring 插件
 * @author linkzz
 * @date 2017-05-17
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
            init(this.ctx);
        } else if(this.configurations != null) {
            init(new FileSystemXmlApplicationContext(this.configurations));
        } else {
            init(new FileSystemXmlApplicationContext(PathKit.getWebRootPath() + "/WEB-INF/applicationContext.xml"));
        }

        return true;
    }

    /**
      * 初始化ApplicationContext 容器
      * @author linkzz
      * @create 2017-11-30 11:13
      */
    public static void init(ApplicationContext applicationContext){
        IocInterceptor.ctx = applicationContext;
    }

    @Override
    public boolean stop() {
        return true;
    }
}
