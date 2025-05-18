package edu.GDPU.Demo.Fee.service;

import edu.GDPU.Demo.Fee.entity.Fee;

import java.util.List;
public interface FeeService {
    List<Fee> getAllFees();
    Fee getFeeByStuId(String stuId);
    boolean addFee(Fee fee);
    boolean updateFee(Fee fee);
    boolean deleteFeeByStuId(String stuId);
}