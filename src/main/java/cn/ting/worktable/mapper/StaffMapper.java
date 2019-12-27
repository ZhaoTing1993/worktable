package cn.ting.worktable.mapper;

import cn.ting.worktable.entity.Staff;

import java.util.List;

public interface StaffMapper {
    int insert(Staff record);

    int insertSelective(Staff record);

    List<Staff> selectByMoudule(String module);

    List<Staff> selectByDepartment(String department);
}