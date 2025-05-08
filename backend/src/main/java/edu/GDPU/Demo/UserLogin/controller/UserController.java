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

    /**
     * 用户登录接口
     *
     * @param user 必须包含username和password的JSON对象
     * @return 登录成功返回用户完整信息（含token），失败返回错误码-1
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestBody User user) {
        User login = userService.login(user);
        if (login != null) {
            return new Result(login);
        }
        return new Result(-1, "用户名或密码错误");
    }

    /**
     * 获取用户详细信息接口
     *
     * @param token URL参数中的认证令牌
     * @return 成功返回用户角色、宿舍等信息，令牌失效返回错误码-1
     */
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public Result getUserByToken(@RequestParam String token) {
        User user = userService.getUserByToken(token);
        if (user != null) {
            return new Result(user);
        }
        return new Result(-1, "您已在其他地方登录");
    }

    /**
     * 用户注销接口
     *
     * @param token 通过请求头X-Token传递的认证令牌
     * @return 成功返回200状态码，失败返回错误码-1
     */
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