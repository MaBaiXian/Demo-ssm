package edu.GDPU.Demo.Student.service.impl;

import edu.GDPU.Demo.Student.entity.Student;
import edu.GDPU.Demo.Student.mapper.StudentMapper;
import edu.GDPU.Demo.Student.service.StudentService;
import edu.GDPU.Demo.UserLogin.entity.User;
import edu.GDPU.Demo.UserLogin.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Student> getStudentByToken(String token) {
        // 1. 校验 token 有效性
        User user = userMapper.selectUserByToken(token);
        if (user == null) {
            throw new RuntimeException("无效的Token");
        }

        // 2. 校验角色（允许 DormAdmin 和 SysAdmin）
        String[] allowedRoles = {"DormAdmin", "SysAdmin"};
        boolean hasPermission = false;
        for (String role : allowedRoles) {
            if (role.equals(user.getRoles())) {
                hasPermission = true;
                break;
            }
        }
        if (!hasPermission) {
            throw new RuntimeException("无权限访问");
        }

        // 3. 查询学生列表
        return studentMapper.getStudentByToken(token);
    }

    // 通用权限校验方法（允许 DormAdmin 和 SysAdmin）
    private void validateAdminRole(String token) {
        User user = userMapper.selectUserByToken(token);
        if (user == null) {
            throw new RuntimeException("无效的Token");
        }

        // 校验角色（允许 DormAdmin 和 SysAdmin）
        String[] allowedRoles = {"DormAdmin", "SysAdmin"};
        boolean hasPermission = false;
        for (String role : allowedRoles) {
            if (role.equals(user.getRoles())) {
                hasPermission = true;
                break;
            }
        }
        if (!hasPermission) {
            throw new RuntimeException("无权限操作");
        }
    }

    @Override
    public int deleteStudent(String token, Integer userId) {
        validateAdminRole(token);  // 通用权限校验
        return studentMapper.deleteStudent(userId);
    }

    @Override
    public int updateStudent(String token, Integer userId, Student student) {
        validateAdminRole(token);
        student.setUserId(userId);  // 绑定要更新的学生 ID
        return studentMapper.updateStudent(student);
    }

    @Override
    public int createStudent(String token, Student student) {
        validateAdminRole(token);
        // 强制设置新学生角色为 Student（避免前端篡改）
        student.setRoles("Student");
        return studentMapper.insertStudent(student);
    }
}