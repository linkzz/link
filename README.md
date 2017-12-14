##前言
    link是基于jfinal、dubbo、activemq、redis、shiro、swagger等开源技术搭建的一套中小企业全业务、全渠道的解决方案。
##项目介绍
    link是基于jfinal、dubbo、activemq
##组织架构
    link
    |--link-common  --公共部分（工具类、及基于jfinal的插件）
    |--link-admin  --后台管理系统模板
    |--link-ui --基于layui的全套前端解决方案
    |--link-config  --分布式系统配置中心
    |--link-upms --企业内部的权限管理系统（单点登录）
    |  |--link-upms-common --upms系统公共模块
    |  |--link-upms-dao  --dao层代码自动生成，无需开发
    |  |--link-upms-rpc-api  --rpc接口
    |  |--link-upms-rpc-service  --rpc接口服务
    |  |--link-upms-client  --集成upms依赖包，提供单点认证、授权、统一会话管理
    |  |--link-upms-server --用户权限系统及sso服务端