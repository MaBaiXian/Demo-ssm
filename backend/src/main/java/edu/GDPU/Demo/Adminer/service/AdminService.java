package edu.GDPU.Demo.Adminer.service;

import edu.GDPU.Demo.Adminer.entity.Admin;
import java.util.List;

public interface AdminService {
    /**
     * 根据 ID 和 Token 查询管理员
     * @param token 用户 Token（用于权限验证）
     * @param id 管理员 ID
     * @return 管理员对象
     */
    Admin getAdminById(String token, Integer id);

    /**
     * 根据 Token 查询所有管理员
     * @param token 用户 Token（用于权限验证）
     * @return 管理员列表
     */
    List<Admin> getAllAdmins(String token);

    /**
     * 根据 Token 创建管理员
     * @param token 用户 Token（用于权限验证）
     * @param admin 待创建的管理员对象
     * @return 受影响的行数（>0 表示成功）
     */
    int createAdmin(String token, Admin admin);

    /**
     * 根据 Token 更新管理员信息
     * @param token 用户 Token（用于权限验证）
     * @param admin 待更新的管理员对象（需包含 ID）
     * @return 受影响的行数（>0 表示成功）
     */
    int updateAdmin(String token, Admin admin);

    /**
     * 根据 Token 和 ID 删除管理员
     * @param token 用户 Token（用于权限验证）
     * @param id 待删除的管理员 ID
     * @return 受影响的行数（>0 表示成功）
     */
    int deleteAdmin(String token, Integer id);

    /**
     * 根据 Token 统计管理员数量
     * @param token 用户 Token（用于权限验证）
     * @return 管理员总数
     */
    long getAdminCount(String token);


}