package edu.GDPU.Demo.Fee.mapper;

import edu.GDPU.Demo.Fee.entity.Fee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface FeeMapper {
    List<Fee> getAllFees();
    Fee getFeeByStuId(String stuId);
    int addFee(Fee fee);
    int updateFee(Fee fee);
    int deleteFeeByStuId(String stuId);
}