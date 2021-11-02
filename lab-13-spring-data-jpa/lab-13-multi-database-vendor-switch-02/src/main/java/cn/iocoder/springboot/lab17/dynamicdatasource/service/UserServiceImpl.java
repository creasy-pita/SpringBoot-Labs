package cn.iocoder.springboot.lab17.dynamicdatasource.service;

import cn.iocoder.springboot.lab17.dynamicdatasource.dataobject.User;
import cn.iocoder.springboot.lab17.dynamicdatasource.repository.UserRepository;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    private UserServiceImpl self() {
        return (UserServiceImpl) AopContext.currentProxy();
    }

    public void method01() {

        // 查询用户
        User user = userRepository.findById(1).orElse(null);
        System.out.println(user);
    }

    @Override
    public void save(User user) {
        userRepository.save( user);
    }


}
