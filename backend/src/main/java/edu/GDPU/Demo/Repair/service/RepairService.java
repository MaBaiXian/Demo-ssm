package edu.GDPU.Demo.Repair.service;

import edu.GDPU.Demo.Repair.entity.RepairDto;
import edu.GDPU.Demo.Repair.entity.RepairVO;
import edu.GDPU.Demo.Repair.entity.Repair;

import java.util.List;

public interface RepairService {
    int saveRepair(Repair repair);
    List<Repair> selectRepairs(RepairDto repairDto, int current, int size);
    int updateRepair(Repair repair);
    int deleteRepair(Integer id);
    RepairVO getRepairInfo(Integer id);
}