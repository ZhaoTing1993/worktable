package cn.ting.worktable.mapper;

import cn.ting.worktable.entity.WorkDetail;

public interface WorkDetailMapper {
    int insert(WorkDetail record);

    int insertSelective(WorkDetail record);
}