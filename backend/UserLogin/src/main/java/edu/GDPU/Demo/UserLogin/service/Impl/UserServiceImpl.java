package edu.GDPU.Demo.UserLogin.service.Impl;


import edu.GDPU.Demo.UserLogin.entity.User;
import edu.GDPU.Demo.UserLogin.mapper.UserMapper;
import edu.GDPU.Demo.UserLogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

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

    @Override
    public User getUserByToken(String token) {
        return userMapper.selectUserByToken(token);
    }

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