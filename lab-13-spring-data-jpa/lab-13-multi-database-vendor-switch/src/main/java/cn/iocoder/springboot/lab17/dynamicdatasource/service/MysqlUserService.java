package cn.iocoder.springboot.lab17.dynamicdatasource.service;

import cn.iocoder.springboot.lab17.dynamicdatasource.dataobject.mysql.MysqlUser;
import cn.iocoder.springboot.lab17.dynamicdatasource.entity.User;
import cn.iocoder.springboot.lab17.dynamicdatasource.repository.mysql.MysqlUserRepository;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(value = "spring.jpa.properties.hibernate.dialect",havingValue = "org.hibernate.dialect.MySQL57Dialect", matchIfMissing = true)
public class MysqlUserService implements UserService {

    @Autowired
    private MysqlUserRepository mysqlUserRepository;


    private MysqlUserService self() {
        return (MysqlUserService) AopContext.currentProxy();
    }

    public void method01() {

        // 查询用户
        User user = mysqlUserRepository.findById(1).orElse(null);
        System.out.println(user);
    }

    @Override
    public void save(User user) {
        mysqlUserRepository.save((MysqlUser) user);
    }


}
