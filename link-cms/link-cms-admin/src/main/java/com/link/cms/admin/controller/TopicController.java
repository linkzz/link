package com.link.cms.admin.controller;

import com.jfinal.core.Controller;
import com.jfinal.kit.LogKit;
import com.link.cms.rpc.api.TopicServiceI;
import com.link.common.plugin.spring.Inject;

/**
 * 专题管理
 * @author linkzz
 * @create 2017-11-23 17:48
 */
public class TopicController extends Controller {

    @Inject.BY_NAME
    TopicServiceI topicService;

    public void sayhello(){
        String str = topicService.sysHello("linkzz");
        LogKit.info("客户端打印：调用成功了！"+str);
        setAttr("sucess",str);
        renderText("哈哈成功了！！！");
    }
}
