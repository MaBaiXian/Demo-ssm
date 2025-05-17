package edu.GDPU.Demo.Student.controller;

import edu.GDPU.Demo.Student.entity.Student;
import edu.GDPU.Demo.Student.service.StudentService;
import edu.GDPU.Demo.Common.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Student")
public class StudentManageController {

    @Autowired
    public StudentService studentService;

    // 调整：从请求头获取 token（与前端实际传递方式一致）
    @GetMapping("/getStudentList")
    public Result getStudentList(@RequestHeader("X-Token") String token) {  // 改为 @RequestHeader
        List<Student> students = studentService.getStudentByToken(token);
        return new Result(students);
    }

    // 调整：路径改为 /deleteStudent/{id}，匹配前端请求 /Student/deleteStudent/6
    @DeleteMapping("/deleteStudent/{id}")  // 原路径为 /{id}，现改为 /deleteStudent/{id}
    public Result delete(@RequestHeader("X-Token") String token, @PathVariable int id) {
        int count = studentService.deleteStudent(token, id);
        return count > 0
                ? new Result(count)
                : new Result(50000, "删除失败");
    }



    // 调整：路径改为 /updateStudent/{id}，匹配前端请求 /Student/updateStudent/3
    @PutMapping("/updateStudent/{id}")  // 原路径为 /{id}，现改为 /updateStudent/{id}
    public Result updateStudent(@RequestHeader("X-Token") String token, @PathVariable int id, @RequestBody Student student) {
        int count = studentService.updateStudent(token, id, student);
        return count > 0
                ? new Result(count)
                : new Result(50001, "更新失败");
    }

    // 调整：路径改为 /createStudent，匹配前端请求 /Student/createStudent
    @PostMapping("/createStudent")  // 原路径为 ""（即 /Student），现改为 /createStudent
    public Result createStudent(@RequestHeader("X-Token") String token, @RequestBody Student student) {
        int count = studentService.createStudent(token, student);
        return count > 0
                ? new Result(count)
                : new Result(50002, "创建失败");
    }
}