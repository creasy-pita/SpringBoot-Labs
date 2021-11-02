package cn.iocoder.springboot.lab17.dynamicdatasource.service;

import cn.iocoder.springboot.lab17.dynamicdatasource.Application1;
import cn.iocoder.springboot.lab17.dynamicdatasource.dataobject.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application1.class)
public class OrderServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testMethod01() {
        userService.method01();
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("john2");
        userService.save(user);

        User user2 = new User();
        user2.setUsername("john3");
        userService.save(user2);
    }

}
