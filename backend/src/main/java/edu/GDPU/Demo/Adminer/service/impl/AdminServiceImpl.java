package edu.GDPU.Demo.Adminer.service.impl;

import edu.GDPU.Demo.Adminer.entity.Admin;
import edu.GDPU.Demo.Adminer.mapper.AdminMapper;
import edu.GDPU.Demo.Adminer.service.AdminService;
import edu.GDPU.Demo.UserLogin.entity.User;
import edu.GDPU.Demo.UserLogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

// ... 原有导入和类定义 ...

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private UserService userService;  // 假设已注入 UserService 用于验证 token

    @Override
    public Admin getAdminById(String token, Integer id) {
        // 验证 token 有效性（即使前端未传，也处理）
        if (token == null || token.isEmpty()) {
            throw new RuntimeException("未登录，请先登录");  // 前端会收到 500 错误，但信息明确
        }
        User user = userService.getUserByToken(token);
        if (user == null) {
            throw new RuntimeException("无效的 Token");
        }
        if (!"SysAdmin".equals(user.getRoles())) {
            throw new RuntimeException("权限不足");
        }
        return adminMapper.selectById(id);
    }

    // 其他方法（getAllAdmins、createAdmin 等）补充相同 token 验证逻辑
    @Override
    public List<Admin> getAllAdmins(String token) {
        if (token == null || token.isEmpty()) {
            throw new RuntimeException("未登录，请先登录");
        }
        User user = userService.getUserByToken(token);
        if (user == null || !"SysAdmin".equals(user.getRoles())) {
            throw new RuntimeException("权限不足");
        }
        return adminMapper.selectList();
    }

    @Override
    public int createAdmin(String token, Admin admin) {
        if (token == null || token.isEmpty()) {
            throw new RuntimeException("未登录，请先登录");
        }
        User user = userService.getUserByToken(token);
        if (user == null || !"SysAdmin".equals(user.getRoles())) {
            throw new RuntimeException("权限不足");
        }
        return adminMapper.insert(admin);
    }

    @Override
    public int updateAdmin(String token, Admin admin) {
        if (token == null || token.isEmpty()) {
            throw new RuntimeException("未登录，请先登录");
        }
        User user = userService.getUserByToken(token);
        if (user == null ||!"SysAdmin".equals(user.getRoles())) {
            throw new RuntimeException("权限不足");
        }
        return adminMapper.updateById(admin);
    }

    @Override
    public int deleteAdmin(String token, Integer id) {
        if (token == null || token.isEmpty()) {
            throw new RuntimeException("未登录，请先登录");
        }
        User user = userService.getUserByToken(token);
        if (user == null ||!"SysAdmin".equals(user.getRoles())) {
            throw new RuntimeException("权限不足");
        }
        return adminMapper.deleteById(id);
    }

    @Override
    public long getAdminCount(String token) {
        return 0;
    }

}