package edu.GDPU.Demo.Student.mapper;

import edu.GDPU.Demo.Student.entity.Student;
import java.util.List;

public interface StudentMapper {
    // 查询 user 表中角色为 Student 的用户
    List<Student> getStudentByToken(String token);

    // 删除 user 表中指定 userId 的学生
    int deleteStudent(Integer userId);

    // 更新 user 表中指定 userId 的学生信息
    int updateStudent(Student student);

    // 向 user 表插入新学生（角色为 Student）
    int insertStudent(Student student);
}