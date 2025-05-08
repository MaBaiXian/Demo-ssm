package edu.GDPU.Demo.UserLogin.controller;


import edu.GDPU.Demo.Common.dto.Result;
import edu.GDPU.Demo.UserLogin.entity.User;
import edu.GDPU.Demo.UserLogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestBody User user) {
        System.out.println("[LOG] 登录请求到达:" + user.getUsername());
        User login = userService.login(user);
        if (login != null) {
            return new Result(login);
        }
        return new Result(-1, "用户名或密码错误");
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public Result getUserByToken(@RequestParam String token) {
        User user = userService.getUserByToken(token);
        if (user != null) {
            return new Result(user);
        }
        return new Result(-1, "您已在其他地方登录");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public Result logout(@RequestHeader("X-Token") String token) {
        boolean success = userService.logout(token);
        if (success) {
            return new Result();
        }
        return new Result(-1, "登出失败");
    }
}