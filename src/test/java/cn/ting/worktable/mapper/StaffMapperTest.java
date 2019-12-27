package cn.ting.worktable.mapper;

import cn.ting.worktable.WorktableApplicationTests;
import cn.ting.worktable.entity.Staff;
import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class StaffMapperTest extends WorktableApplicationTests {

    @Autowired
    private StaffMapper staffMapper;

    @Test
    void selectByMoudule() {
        List<Staff> staffs = staffMapper.selectByMoudule("Config");
        System.out.println(JSONArray.toJSONString(staffs));
    }
}