package cn.ting.worktable.mapper;

import cn.ting.worktable.entity.WorkDetail;

import java.util.List;

public interface WorkDetailMapper {
    int insert(WorkDetail record);

    int insertSelective(WorkDetail record);

    WorkDetail selectSelective(WorkDetail workDetail);
    List<WorkDetail> selectAll();
}