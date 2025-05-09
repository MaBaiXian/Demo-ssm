package edu.GDPU.Demo.UserLogin.service.impl;


import edu.GDPU.Demo.UserLogin.entity.User;
import edu.GDPU.Demo.UserLogin.mapper.UserMapper;
import edu.GDPU.Demo.UserLogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录认证实现
     * 1. 验证用户名密码
     * 2. 生成新token（基于时间戳的临时方案）
     * 3. 更新用户token到数据库
     *
     * @param user 包含username和password的用户对象
     * @return 携带新token的用户实体，失败返回null
     */
    @Override
    public User login(User user) {
        User existUser = userMapper.selectUserByUsernameAndPassword(user);
        if (existUser != null) {
            String newToken = System.currentTimeMillis() + "";
            existUser.setToken(newToken);
            userMapper.updateUserToken(existUser);
            return existUser;
        }
        return null;
    }

    /**
     * 通过token查询用户信息
     *
     * @param token 当前有效的用户令牌
     * @return 用户实体对象（包含角色、宿舍等信息），令牌无效时返回null
     */
    @Override
    public User getUserByToken(String token) {
        return userMapper.selectUserByToken(token);
    }

    /**
     * 用户注销实现
     * 1. 通过token查询用户
     * 2. 清空用户token字段
     * 3. 更新数据库
     *
     * @param token 需要注销的令牌
     * @return 是否成功清除令牌
     */
    @Override
    public boolean logout(String token) {
        User user = userMapper.selectUserByToken(token);
        if (user != null) {
            user.setToken(null);
            userMapper.updateUserToken(user);
            return true;
        }
        return false;
    }
}