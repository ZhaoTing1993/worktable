package cn.ting.worktable.mapper;

import cn.ting.worktable.entity.WorkModule;

import java.util.List;

public interface WorkModuleMapper {
    int insert(WorkModule record);

    int insertSelective(WorkModule record);

    WorkModule selectByName(String moduleName);

}