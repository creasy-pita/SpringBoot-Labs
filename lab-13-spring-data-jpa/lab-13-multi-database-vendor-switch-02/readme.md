# 描述

creasypita
spring + jpa + hibernate实现mysql,postgres数据库类型切换


通过`hibernate xml`覆盖 `annotation`的 方式， 优先级前者高：参考： https://thorben-janssen.com/hibernate-tips-override-primary-key-generation-strategy/

实现方式 参考apollo的mysql,pg切换处理
1 代码可以根据数据库类型动态切换Dao层配置：通过xml优先级覆盖annotation的方式来实现 mysql,pgsql的切换
2 apollo entity column注解统一修改为小写
3 mysql @Lob字段定义迁移到orm-mysql.xml
4 配置文件的driver会根据传入的数据库url中的数据库类型修改
