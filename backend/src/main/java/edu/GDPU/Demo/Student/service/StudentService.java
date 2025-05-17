package edu.GDPU.Demo.Student.service;

import edu.GDPU.Demo.Student.entity.Student;
import java.util.List;

public interface StudentService {
    // 查询学生列表（带 token 校验）
    List<Student> getStudentByToken(String token);

    // 删除学生（带 token 校验）
    int deleteStudent(String token, Integer userId);

    // 更新学生（带 token 校验）
    int updateStudent(String token, Integer userId, Student student);

    // 创建学生（带 token 校验）
    int createStudent(String token, Student student);

}