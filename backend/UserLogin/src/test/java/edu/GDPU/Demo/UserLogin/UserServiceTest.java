package edu.GDPU.Demo.UserLogin;

import edu.GDPU.Demo.UserLogin.entity.User;
import edu.GDPU.Demo.UserLogin.service.Impl.UserServiceImpl;
import edu.GDPU.Demo.UserLogin.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    // 测试登录功能
    public void testLogin() {
        User user = new User();
        user.setUsername("student");
        user.setPassword("111111");
        User login = userService.login(user);
        if (login != null) {
            System.out.println("登录成功");
            System.out.println("用户信息: " + login);
        } else {
            System.out.println("登录失败");
        }
    }
}
