## 项目介绍
    link-upms 用户权限管理系统，本系统是基于RBAC授权和基于用户授权的细粒度权限控制通用平台，
    并提供单点登录、会话管理和日志管理。接入的系统可自由定义组织、角色、权限、资源等
## 项目架构
    link-upms --企业内部的权限管理系统（单点登录）
    |--link-upms-common --upms系统公共模块
    |--link-upms-dao  --dao层代码自动生成，无需开发
    |--link-upms-rpc-api  --rpc接口
    |--link-upms-rpc-service  --rpc接口服务
    |--link-upms-client  --集成upms依赖包，提供单点认证、授权、统一会话管理
    |--link-upms-server --用户权限系统及sso服务端