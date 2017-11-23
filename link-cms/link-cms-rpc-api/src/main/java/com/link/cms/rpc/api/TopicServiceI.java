package com.link.cms.rpc.api;

import com.link.cms.common.common.ResultJson;
import com.link.cms.model.Topic;
import com.link.cms.rpc.api.base.BaseServiceI;

/**
 * 专题管理
 *
 * @author linkzz
 * @create 2017-10-27 15:05
 */
public interface TopicServiceI extends BaseServiceI {
    ResultJson save(Topic model);

    Topic getTopicById(String id);

    String sysHello(String name);
}
