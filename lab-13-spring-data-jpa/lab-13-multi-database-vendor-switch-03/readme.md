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

问题

上层的控制器Service,需要使用 new User(),以及设置属性，那么User需要定义所有表列对应的字段。PgUser需要`覆盖重写`User的 @GeneratorValue 注解。  但目前没有办法实现：Attribute override for @GeneratedValue

覆盖重写的方式： 

1  通过***@AttributeOverride\*** ，参考： Attribute override for @GeneratedValue： https://community.oracle.com/tech/developers/discussion/1570930/attribute-override-for-generatedvalue

2 通过`hibernate xml`覆盖 `annotation`的 方式， 优先级前者高：参考： https://thorben-janssen.com/hibernate-tips-override-primary-key-generation-strategy/



>  :bulb:**第一种不可行，第二种可行，进一步验证**
>
>  :bulb::star::star: 需要验证 第二种使用于 jpa 2.x + Hibernate 5.x; 不适用于 jpa 1.x + Hibernate 4.x。 主要验证方式，是否生成SequenceGenerator



注意点
1 物理表对应的实体类MysqlUser,PgsqlUser继承的User，**hibernate可以不用扫描**，用于定义通用的字段；

