# @Configuration 注解的扫描

springbootapplication类第一轮循环会去扫描@Configuration 注解类，先判断条件注解，条件注解通过的会加入beandefination列表；
第二轮循环会去处理 @PropertySource注解的配置，加载到enviroment中。

类扫描顺序是 AConfiguration，B0Configuration，B1Configuration，B2Configuration，CConfiguration
但是第一轮`platform.properties文件没加载`所以 `spring.name=a`  条件注解不通过；B2Configuration，CConfiguration都没有通过。
所以不会再第二轮的循环队伍中。
第二轮B1Configuration注解的@PropertySource会去加载配置到 environment中，但这一轮CConfiguration顺序虽然在后，看似没有拿到配置，其实是第一轮不通过，不在第二轮的队伍当中了。


spring的applicationcontext.refresh 方法再去注册和初始化这些bean,此时会执行  @postconstruct注解的方法 






