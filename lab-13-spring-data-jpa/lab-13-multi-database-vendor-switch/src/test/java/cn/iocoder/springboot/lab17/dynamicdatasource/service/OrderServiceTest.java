package cn.iocoder.springboot.lab17.dynamicdatasource.service;

import cn.iocoder.springboot.lab17.dynamicdatasource.Application1;
import cn.iocoder.springboot.lab17.dynamicdatasource.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application1.class)
public class OrderServiceTest {

//    @Autowired
//    private MysqlUserService userService;

    @Autowired
    private UserService userService;

    @Test
    public void testMethod01() {
        userService.method01();
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setId(2);
        user.setUsername("john");
        userService.save(user);
    }

}
