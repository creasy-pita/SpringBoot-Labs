
## 2022-06-06

使用profiles特性配置多properties文件: spring.profiles.active= local,local.1,local.2
几种环境信息配置的方式如下：

- 1 命令行参数，command line argument
  配置方式
  java -jar --argname1=value1 --argname2=value2
  java -jar --spring.application.port=19064 --spring.application.name=ruleexcutor
- 2 java system properties
  java -Dargname1=value1 -Dargname2=value2 -jar
  java -Dspring.application.port=19064 -Dspring.application.name=ruleexcutor -jar

- 3 操作系统 环境变量 os system
  比如
  1 操作系统配置环境变量： ENV_PROFILE=dev
  2 application.properties文件中加入如下内容

:bulb: 配置OS 环境变量后需要重启idea才能生效

```properties
spring.profiles.active=${ENV_PROFILE}
```

参考： 
https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.external-config
https://www.cnblogs.com/huanzi-qch/p/10411581.html
## 2022-05-06
参考： https://mkyong.com/spring-boot/spring-boot-profile-based-properties-and-yaml-example/

