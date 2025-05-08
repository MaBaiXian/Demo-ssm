package edu.GDPU.Demo.UserLogin.service;


import edu.GDPU.Demo.UserLogin.entity.User;

public interface UserService {

    /**
     * 用户登录认证
     * @param user 包含username和password属性的用户对象
     * @return 登录成功的用户实体（包含token等完整信息），认证失败返回null
     */
    User login(User user);

    /**
     * 通过认证令牌获取用户信息
     * @param token 当前有效的令牌
     * @return 包含角色、宿舍等信息的用户实体，令牌无效时返回null
     */
    User getUserByToken(String token);

    /**
     * 用户注销登录
     * @param token 当前有效的认证令牌
     * @return true=注销成功，false=注销失败
     */
    boolean logout(String token);
}
