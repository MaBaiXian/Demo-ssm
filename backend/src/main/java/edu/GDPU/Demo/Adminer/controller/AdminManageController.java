package edu.GDPU.Demo.Adminer.controller;

import edu.GDPU.Demo.Adminer.entity.Admin;
import edu.GDPU.Demo.Adminer.service.AdminService;
import edu.GDPU.Demo.Common.dto.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
// ... 原有导入和类定义 ...

@RestController
@RequestMapping("/Admin")
public class AdminManageController {

    @Autowired
    private AdminService adminService;

    // 获取单个管理员（修改点：X-Token 非必需）
    @GetMapping("/{id}")
    public Result getAdminById(
            @RequestHeader(value = "X-Token", required = false, defaultValue = "") String token,  // 非必需
            @PathVariable Integer id
    ) {
        Admin admin = adminService.getAdminById(token, id);
        return admin != null ? new Result(admin) : new Result(500, "管理员不存在");
    }

    // 获取管理员列表（修改点：X-Token 非必需）
    @GetMapping("/list")
    public Result getAllAdmins(
            @RequestHeader(value = "X-Token", required = false, defaultValue = "") String token  // 非必需
    ) {
        List<Admin> admins = adminService.getAllAdmins(token);
        return new Result(admins);
    }

    // 新增兼容接口（路径 /getAdminList），映射到 getAllAdmins 方法
    @GetMapping("/getAdminList")
    public Result getAdminList(@RequestHeader("X-Token") String token) {
        return getAllAdmins(token);  // 直接复用原有逻辑
    }

    // 创建管理员（修改点：X-Token 非必需）
    @PostMapping("")
    public Result createAdmin(
            @RequestHeader(value = "X-Token", required = false, defaultValue = "") String token,  // 非必需
            @RequestBody Admin admin
    ) {
        int result = adminService.createAdmin(token, admin);
        return result > 0 ? new Result(admin) : new Result(500, "创建管理员失败");
    }
    // 新增兼容接口（路径 /createAdmin），映射到原有逻辑
    @PostMapping("/createAdmin")
    public Result createAdminByPath(@RequestHeader("X-Token") String token, @RequestBody Admin admin) {
        return createAdmin(token, admin);  // 复用原有方法
    }



    // 更新管理员（修改点：强制使用路径中的 id，忽略前端传递的 userId）
    @PutMapping("/{id}")
    public Result updateAdmin(@RequestHeader("X-Token") String token, @PathVariable Integer id, @RequestBody Admin admin) {
        // 强制设置 userId 为路径中的 id，覆盖前端传递的 userId
        admin.setUserId(id);
        int result = adminService.updateAdmin(token, admin);
        return result > 0 ? new Result(admin) : new Result(500, "更新管理员失败");
    }

    // 新增的兼容接口（/updateAdmin/{id}）同样需要强制设置 userId
    @PutMapping("/updateAdmin/{id}")
    public Result updateAdminByPath(@RequestHeader("X-Token") String token, @PathVariable Integer id, @RequestBody Admin admin) {
        admin.setUserId(id);  // 新增：强制设置 userId
        return updateAdmin(token, id, admin);
    }

    // 删除管理员（修改点：X-Token 非必需）
    @DeleteMapping("/{id}")
    public Result deleteAdmin(
            @RequestHeader(value = "X-Token", required = false, defaultValue = "") String token,  // 非必需
            @PathVariable Integer id
    ) {
        int result = adminService.deleteAdmin(token, id);
        return result > 0 ? new Result("删除成功") : new Result(500, "删除管理员失败");
    }
    // 新增兼容接口（路径 /deleteAdmin），映射到原有逻辑
    // 新增兼容接口（路径 /Admin/deleteAdmin/{id}），映射到原有删除逻辑
    @DeleteMapping("/deleteAdmin/{id}")
    public Result deleteAdminByPath(@RequestHeader("X-Token") String token, @PathVariable Integer id) {
        return deleteAdmin(token, id);  // 复用原有方法
    }

    // 获取管理员数量（修改点：X-Token 非必需）
    @GetMapping("/count")
    public Result getAdminCount(
            @RequestHeader(value = "X-Token", required = false, defaultValue = "") String token  // 非必需
    ) {
        long count = adminService.getAdminCount(token);
        return new Result(count);
    }
}