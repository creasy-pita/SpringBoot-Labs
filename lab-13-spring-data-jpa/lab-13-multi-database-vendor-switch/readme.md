# 描述

creasypita
spring + jpa + hibernate实现mysql,postgres数据库类型切换

已知的知识点

- `CrudRepository<MysqlUser, Integer>`中的需要传入具体的物理表对应的实体类，而不是被继承的上层类`User`

```java
//如果传入的MysqlUser，内部可以确定MysqlUser是jpa的entity,  但是UserRepository只能是mysql时使用，
// 如果传入User,可以传入mysqluser,pguser，但是内部确定的User不是一个合格的jpa entity，会报错
 public interface UserRepository extends CrudRepository<MysqlUser, Integer> {

}
```



实现方式：

- MysqlUser,PgsqlUser继承的User, User中定义通用的字段
- User中不定义涉及主键生成器`Generateor`的id字段，交给子类定义
- 因为`CrudRepository<Entity, Integer>`的原因，Repository分两套，pg和mysql
- Service层使用接口方式，具体使用pg还是mysql的Service实现类，按`@ConditionalOnProperty`条件加载



注意点
1 物理表对应的实体类MysqlUser,PgsqlUser继承的User，**hibernate可以不用扫描**，用于定义通用的字段；

