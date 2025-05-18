package edu.GDPU.Demo.Fee.service.impl;

import edu.GDPU.Demo.Fee.mapper.FeeMapper;
import edu.GDPU.Demo.Fee.entity.Fee;
import edu.GDPU.Demo.Fee.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FeeServiceImpl implements FeeService {
    @Autowired
    private FeeMapper feeMapper;

    @Override
    public List<Fee> getAllFees() {
        return feeMapper.getAllFees();
    }

    @Override
    public Fee getFeeByStuId(String stuId) {
        return feeMapper.getFeeByStuId(stuId);
    }

    @Override
    public boolean addFee(Fee fee) {
        return feeMapper.addFee(fee) > 0;
    }

    @Override
    public boolean updateFee(Fee fee) {
        return feeMapper.updateFee(fee) > 0;
    }

    @Override
    public boolean deleteFeeByStuId(String stuId) {
        return feeMapper.deleteFeeByStuId(stuId) > 0;
    }
}