package edu.GDPU.Demo.Repair.service.impl;

import edu.GDPU.Demo.Repair.entity.RepairDto;
import edu.GDPU.Demo.Repair.entity.RepairVO;
import edu.GDPU.Demo.Repair.entity.Repair;
import edu.GDPU.Demo.Repair.mapper.RepairMapper;
import edu.GDPU.Demo.Repair.service.RepairService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairServiceImpl implements RepairService {

    @Autowired
    private RepairMapper repairMapper;

    @Override
    public int saveRepair(Repair repair) {
        return repairMapper.insertRepair(repair);
    }

    @Override
    public List<Repair> selectRepairs(RepairDto repairDto, int current, int size) {
        int offset = (current - 1) * size;
        RowBounds rowBounds = new RowBounds(offset, size);
        return repairMapper.selectRepairs(repairDto);
    }

    @Override
    public int updateRepair(Repair repair) {
        return repairMapper.updateRepair(repair);
    }

    @Override
    public int deleteRepair(Integer id) {
        return repairMapper.deleteRepair(id);
    }

    @Override
    public RepairVO getRepairInfo(Integer id) {
        return repairMapper.getRepairInfo(id);
    }
}