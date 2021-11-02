package cn.iocoder.springboot.lab17.dynamicdatasource.service;

import cn.iocoder.springboot.lab17.dynamicdatasource.entity.User;
import cn.iocoder.springboot.lab17.dynamicdatasource.repository.pg.PostgresUserRepository;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(value = "spring.jpa.properties.hibernate.dialect", havingValue = "org.hibernate.dialect.PostgreSQL9Dialect")
public class PostgresUserService implements UserService {

    @Autowired
    private PostgresUserRepository postgresUserRepository;


    private PostgresUserService self() {
        return (PostgresUserService) AopContext.currentProxy();
    }

    public void method01() {

        // 查询用户
        User user = postgresUserRepository.findById(1).orElse(null);
        System.out.println(user);
    }


}
