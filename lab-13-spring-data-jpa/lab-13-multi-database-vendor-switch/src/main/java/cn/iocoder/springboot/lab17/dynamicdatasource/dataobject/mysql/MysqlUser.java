package cn.iocoder.springboot.lab17.dynamicdatasource.dataobject.mysql;

import cn.iocoder.springboot.lab17.dynamicdatasource.entity.User;

import javax.persistence.*;

/**
 * 用户 DO
 */
@Entity
@Table(name = "users")
public class MysqlUser extends User {

    /**
     * 用户编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,  // strategy 设置使用数据库主键自增策略；
            generator = "JDBC") // generator 设置插入完成后，查询最后生成的 ID 填充到该属性中。
    private Integer id;
    /**
     * 账号
     */
//    private String username;

    public Integer getId() {
        return id;
    }

    public MysqlUser setId(Integer id) {
        this.id = id;
        return this;
    }

//    public String getUsername() {
//        return username;
//    }
//
//    public MysqlUser setUsername(String username) {
//        this.username = username;
//        return this;
//    }

    @Override
    public String toString() {
        return "MysqlUser{" +
                "id=" + id +
                ", username='" + super.getUsername() + '\'' +
                '}';
    }

}
