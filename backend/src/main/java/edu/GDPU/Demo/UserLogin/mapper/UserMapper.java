package edu.GDPU.Demo.UserLogin.mapper;

import edu.GDPU.Demo.UserLogin.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    /**
     * 根据用户名和密码查询用户信息
     *
     * @param user 必须包含username和password属性的用户对象
     * @return 匹配的用户实体对象，包含用户所有属性信息；若无匹配结果则返回null
     */
    User selectUserByUsernameAndPassword(User user);

    /**
     * 根据认证令牌查询用户信息
     *
     * @param token 用户会话令牌（对应User实体token字段）
     * @return 匹配的用户实体对象，包含角色、宿舍等信息；未找到返回null
     */
    User selectUserByToken(String token);

    /**
     * 更新用户认证令牌
     *
     * @param user 必须包含userId和token属性的用户对象
     * @return 受影响的行数（>=1=更新成功，0=更新失败）
     */
    int updateUserToken(User user);
}
