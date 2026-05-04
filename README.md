[SpringCloud.md](https://github.com/user-attachments/files/27350855/SpringCloud.md)
# 分布式基础

+ 单体架构------集群架构-----分布式架构

  - 集群架构----nginx代理----负载均衡------解决大并发

  - 分布式架构----解决模块化升级，多语言团队的问题

    ​                   -----一个大型应用被拆分成很多小应用分别部署在各个机器

    - 独立部署，数据隔离，语言无关

+ 注册中心/配置中心（Nacos）

+ 远程调用(openfeign)----日志，超时控制，重试机制，拦截器。fallback兜底返回

+ 服务熔断&服务降级（sentinel）解决服务雪崩

+ 网关（gateway）

+ 分布式事务(seata)

