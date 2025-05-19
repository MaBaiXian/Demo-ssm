package edu.GDPU.Demo.Fee.controller;

import edu.GDPU.Demo.Common.dto.Result;
import edu.GDPU.Demo.Fee.entity.Fee;
import edu.GDPU.Demo.Fee.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/fees")
public class FeeController {
    @Autowired
    private FeeService feeService;
    @GetMapping
    public ResponseEntity<List<Fee>> getAllFees() {
        List<Fee> fees = feeService.getAllFees();
        return new ResponseEntity<>(fees, HttpStatus.OK);
    }

    @GetMapping("/{stu_id}")
    public ResponseEntity<Fee> getFeeByStuId(@PathVariable String stu_id) {
        Fee fee = feeService.getFeeByStuId(stu_id);
        if(fee != null) {
            return new ResponseEntity<>(fee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public Result addFee(@RequestBody Fee fee) {
        if (feeService.addFee(fee)) {
            return new Result(20000, "Fee added successfully");
        }
        return new Result(400, "Failed to add fee");
    }

    @PutMapping
    public Result updateFee(@RequestBody Fee fee) {
        if (feeService.updateFee(fee)) {
            return new Result(20000, "Fee updated successfully");
        }
        return new Result(400, "Failed to update fee");
    }

    @DeleteMapping("/deleteById/{stu_id}")
    @ResponseBody
    public Result deleteFeeByStuId(@PathVariable String stu_id) {
        if (feeService.deleteFeeByStuId(stu_id)) {
            return new Result(20000, "Fee deleted successfully");
        }
        return new Result(400, "Failed to delete fee");
    }
}