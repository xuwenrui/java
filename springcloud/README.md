# springcloud
## eureka-server
注册中心
## member-service
用户服务
## order-service
订单服务。restTemplate方式调用，支持负载均衡
## zuul-server## 
网关
## order-feign-service
订单服务。feign方式调用。Hystrix提供了熔断、隔离、Fallback。支持负载均衡
## config-server
配置服务。读取git上的配置
## config-client
配置客户端
