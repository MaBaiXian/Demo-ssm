package edu.GDPU.Demo.Adminer.mapper;

import edu.GDPU.Demo.Adminer.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface AdminMapper {
    Admin selectById(Integer id);  // 参数类型改为Integer（与数据库主键类型一致）
    List<Admin> selectList();
    int insert(Admin admin);
    int updateById(Admin admin);
    int deleteById(Integer id);
    Long selectCount();  // 统计管理员数量（用于分页）
}