package com.link.cms.rpc.service.impl;

import com.jfinal.kit.LogKit;
import com.link.cms.common.common.ResultJson;
import com.link.cms.model.Topic;
import com.link.cms.rpc.api.TopicServiceI;
import com.link.cms.rpc.service.impl.base.BaseServiceImpl;

/**
  * 专题管理服务
  * @author linkzz
  * @create 2017-11-30 12:49
  */
public class TopicServiceImpl extends BaseServiceImpl implements TopicServiceI {
    @Override
    public ResultJson save(Topic model) {
        return null;
    }

    @Override
    public Topic getTopicById(String id) {
        return null;
    }

    @Override
    public String sysHello(String name) {
        LogKit.info("服务端被调用！");
        return name;
    }
}
