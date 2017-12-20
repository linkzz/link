## 前言
    link是基于jfinal、dubbo、activemq、redis、shiro、swagger等开源技术搭建的一套中小企业全业务、全渠道的解决方案。
## 项目介绍
    link是基于jfinal、dubbo、activemq
## 组织架构
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
    |--link-cms  --内容管理系统
    |  |--link-cms-common --cms系统公共模块
    |  |--link-cms-dao  --dao层代码自动生成，无需开发
    |  |--link-cms-rpc-api  --cms系统rpc接口
    |  |--link-cms-rpc-service  --cms系统rpc接口服务
    |  |--link-cms-admin  --cms管理系统
    |  |--link-cms-web  --cms前端系统
    |--link-pay  --支付系统
    |  |--link-pay-common  --支付系统公共模块
    |  |--link-pay-api  --第三方支付系统对外接口
    |  |--link-pay-web  --第三方支付系统交互平台
    |  |  |--link-pay-web-admin  --运营管理平台
    |  |  |--link-pay-web-gateway  --支付网关系统
    |  |--link-pay-rpc-api  --支付系统服务接口
    |  |  |--link-pay-rpc-api-account  --账户服务接口
    |  |  |--link-pay-rpc-api-bank  --银行管理服务接口
    |  |  |--link-pay-rpc-api-banklink  --银行后置服务接口
    |  |  |--link-pay-rpc-api-cost  --成本计算服务接口
    |  |  |--link-pay-rpc-api-fee  --商户计费服务接口
    |  |  |--link-pay-rpc-api-limit  --交易限制服务接口
    |  |  |--link-pay-rpc-api-remit  --打款服务接口
    |  |  |--link-pay-rpc-api-trade  --交易服务接口
    |  |  |--link-pay-rpc-api-payrule  --支付规则服务接口
    |  |  |--link-pay-rpc-api-settlement  --结算服务接口
    |  |  |--link-pay-rpc-api-user  --用户服务接口
    |  |  |--link-pay-rpc-api-notify  --通知服务接口
    |  |--link-pay-rpc-serivce  --支付系统服务
    |  |  |--link-pay-rpc-serivce-account  --账户服务
    |  |  |--link-pay-rpc-serivce-bank  --银行管理服务
    |  |  |--link-pay-rpc-serivce-banklink  --银行后置服务
    |  |  |--link-pay-rpc-serivce-cost  --成本计算服务
    |  |  |--link-pay-rpc-serivce-fee  --商户计费服务
    |  |  |--link-pay-rpc-serivce-limit  --交易限制服务
    |  |  |--link-pay-rpc-serivce-remit  --打款服务
    |  |  |--link-pay-rpc-serivce-trade  --交易服务
    |  |  |--link-pay-rpc-serivce-payrule  --支付规则服务
    |  |  |--link-pay-rpc-serivce-settlement  --结算服务
    |  |  |--link-pay-rpc-serivce-user  --用户服务
    |  |  |--link-pay-rpc-serivce-notify  --通知服务
    