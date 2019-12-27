package cn.ting.worktable.mapper;

import cn.ting.worktable.entity.Task;

import java.util.List;

public interface TaskMapper {
    int insert(Task record);

    int insertSelective(Task record);

    List<Task> selectByModule(String module);
}