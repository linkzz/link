##link-pay 是link产品线中的重要产品，采用分布式架构体系构建的第三方支付系统
link-pay
|--link-pay-common  --支付系统公共模块
|--link-pay-api  --第三方支付系统对外接口
|--link-pay-rpc-api  --支付系统服务接口
|  |--link-pay-rpc-api-account  --账户服务接口
|  |--link-pay-rpc-api-bank  --银行管理服务接口
|  |--link-pay-rpc-api-banklink  --银行后置服务接口
|  |--link-pay-rpc-api-cost  --成本计算服务接口
|  |--link-pay-rpc-api-fee  --商户计费服务接口
|  |--link-pay-rpc-api-limit  --交易限制服务接口
|  |--link-pay-rpc-api-remit  --打款服务接口
|  |--link-pay-rpc-api-trade  --交易服务接口
|  |--link-pay-rpc-api-payrule  --支付规则服务接口
|  |--link-pay-rpc-api-settlement  --结算服务接口
|  |--link-pay-rpc-api-user  --用户服务接口
|  |--link-pay-rpc-api-notify  --通知服务接口
|--link-pay-rpc-serivce  --支付系统服务
|  |--link-pay-rpc-serivce-account  --账户服务
|  |--link-pay-rpc-serivce-bank  --银行管理服务
|  |--link-pay-rpc-serivce-banklink  --银行后置服务
|  |--link-pay-rpc-serivce-cost  --成本计算服务
|  |--link-pay-rpc-serivce-fee  --商户计费服务
|  |--link-pay-rpc-serivce-limit  --交易限制服务
|  |--link-pay-rpc-serivce-remit  --打款服务
|  |--link-pay-rpc-serivce-trade  --交易服务
|  |--link-pay-rpc-serivce-payrule  --支付规则服务
|  |--link-pay-rpc-serivce-settlement  --结算服务
|  |--link-pay-rpc-serivce-user  --用户服务
|  |--link-pay-rpc-serivce-notify  --通知服务