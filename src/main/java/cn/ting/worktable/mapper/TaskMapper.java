package cn.ting.worktable.mapper;

import cn.ting.worktable.entity.Task;

public interface TaskMapper {
    int insert(Task record);

    int insertSelective(Task record);
}