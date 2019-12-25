package cn.ting.worktable.mapper;

import cn.ting.worktable.entity.Staff;

public interface StaffMapper {
    int insert(Staff record);

    int insertSelective(Staff record);
}