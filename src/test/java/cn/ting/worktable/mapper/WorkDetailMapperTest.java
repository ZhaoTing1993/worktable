package cn.ting.worktable.mapper;

import cn.ting.worktable.WorktableApplicationTests;
import cn.ting.worktable.entity.WorkDetail;
import org.assertj.core.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class WorkDetailMapperTest extends WorktableApplicationTests {

    @Autowired
    private WorkDetailMapper workDetailMapper;

    @Test
    void insertSelective() {
        WorkDetail workDetail = new WorkDetail();
        workDetail.setStaffName("aa");
        workDetail.setStaffPos("bwfg");
        workDetail.setModule("module1");
        workDetail.setTaskName("task1");
        workDetail.setDueDay(DateUtil.yesterday());
        workDetail.setStartTime(DateUtil.yesterday());
        workDetail.setEndTime(DateUtil.now());
        int i = workDetailMapper.insertSelective(workDetail);
        assert i > 0;
    }
}