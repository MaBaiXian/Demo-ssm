package edu.GDPU.Demo.Repair.mapper;

import edu.GDPU.Demo.Repair.entity.RepairDto;
import edu.GDPU.Demo.Repair.entity.RepairVO;
import edu.GDPU.Demo.Repair.entity.Repair;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RepairMapper {
    @Select("select t1.*,t2.username as student from repair t1 left join user t2 on t2.userId=t1.applicant where t1.id=#{id}")
    public RepairVO getRepairInfo(Integer id);

    int insertRepair(Repair repair);
    int updateRepair(Repair repair);
    int deleteRepair(Integer id);
    List<Repair> selectRepairs(@Param("repairDto") RepairDto repairDto);
}