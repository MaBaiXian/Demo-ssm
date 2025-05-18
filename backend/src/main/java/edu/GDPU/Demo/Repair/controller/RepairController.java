package edu.GDPU.Demo.Repair.controller;

import edu.GDPU.Demo.Common.dto.Result;
import edu.GDPU.Demo.Repair.entity.Repair;
import edu.GDPU.Demo.Repair.entity.RepairDto;
import edu.GDPU.Demo.Repair.entity.RepairVO;
import edu.GDPU.Demo.Repair.service.RepairService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/repair")
public class RepairController {

    @Autowired
    private RepairService repairService;

    @PostMapping(value = "/add")
    public Result add(@RequestBody Repair repair) {
        if (repair.getTitle() == null || repair.getTitle().isEmpty()) {
            return new Result(-1, "维修标题不能为空");
        }
        if (repair.getContent() == null || repair.getContent().isEmpty()) {
            return new Result(-1, "维修内容不能为空");
        }
        int rt = repairService.saveRepair(repair);
        if (rt > 0) {
            return new Result(20000, "提交申请成功");
        } else {
            return new Result(-1, "提交申请失败！");
        }
    }

    @PostMapping(value = "/update")
    public Result update(@RequestBody RepairDto repair) {
        Repair repair1 = new Repair();
        BeanUtils.copyProperties(repair, repair1);
        int rt = repairService.updateRepair(repair1);
        if (rt > 0) {
            return new Result("修改成功！");
        } else {
            return new Result(-1, "修改失败！");
        }
    }

    @PostMapping(value = "/list/{current}/{size}")
    public Result list(
            @PathVariable int current,
            @PathVariable int size,
            @RequestBody(required = false) RepairDto repairDto
    ) {
        List<Repair> repairList = repairService.selectRepairs(repairDto, current, size);
        return new Result(repairList);
    }

    @GetMapping(value = "/info/{repairId}")
    public Result getRepairInfo(@PathVariable Integer repairId) {
        RepairVO repairVO = repairService.getRepairInfo(repairId);
        if (Objects.nonNull(repairVO)) {
            return new Result(repairVO);
        } else {
            return new Result(-1, "信息查询失败！");
        }
    }

    @GetMapping(value = "/delete/{id}")
    public Result deleteRepair(@PathVariable Integer id) {
        int i = repairService.deleteRepair(id);
        if (i > 0) {
            return new Result("删除成功！");
        } else {
            return new Result(-1, "删除失败！");
        }
    }
}