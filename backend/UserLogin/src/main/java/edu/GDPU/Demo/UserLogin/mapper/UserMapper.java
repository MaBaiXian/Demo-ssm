package edu.GDPU.Demo.UserLogin.mapper;

import edu.GDPU.Demo.UserLogin.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User selectUserByUsernameAndPassword(User user);

    User selectUserByToken(String token);

    int updateUserToken(User user);
}
