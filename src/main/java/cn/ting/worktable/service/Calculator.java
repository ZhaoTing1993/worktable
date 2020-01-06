package cn.ting.worktable.service;

import cn.ting.worktable.entity.Staff;
import cn.ting.worktable.entity.Task;
import cn.ting.worktable.entity.WorkDetail;
import cn.ting.worktable.entity.WorkModule;
import cn.ting.worktable.mapper.StaffMapper;
import cn.ting.worktable.mapper.TaskMapper;
import cn.ting.worktable.mapper.WorkDetailMapper;
import cn.ting.worktable.mapper.WorkModuleMapper;
import cn.ting.worktable.model.WorkDetailExcelModel;
import cn.ting.worktable.util.HolidayUtils;
import cn.ting.worktable.util.excel.ExcelUtil;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class Calculator {

    @Autowired
    private WorkModuleMapper workModuleMapper;
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private WorkDetailMapper workDetailMapper;
    @Autowired
    private TaskMapper taskMapper;

    public void calcByModule(String moduleName) {
        WorkModule workModule = workModuleMapper.selectByName(moduleName);
        List<Staff> staffs = staffMapper.selectByMoudule(moduleName);
        List<Task> tasks = taskMapper.selectByModule(moduleName);
        BigDecimal totoalHour = workModule.getWorkHour();

        BigDecimal workDay = totoalHour.divide(new BigDecimal(8));
        Date current = workModule.getStartDay();
        ArrayList<WorkDetail> workDetails = new ArrayList<>();
        ArrayList<WorkDetailExcelModel> workDetailExcelModels = new ArrayList<>();

        HashMap<String, Integer> taskWorkHourMap = new HashMap<>();
        int totalWeight = 0;
        for (Task task : tasks) {
            totalWeight += task.getWeight();
        }
        for (Task task : tasks) {
            Integer weight = task.getWeight();
            BigDecimal taskHour = new BigDecimal(weight).divide(new BigDecimal(totalWeight)).multiply(totoalHour);
            taskWorkHourMap.put(task.getTaskName(), taskHour.intValue());
        }

        while (totoalHour.compareTo(BigDecimal.ZERO) > 0) {

            for (Staff staff : staffs) {
                List<Task> spTasks = tasks.stream().filter(task -> {
                    return task.getStaffPos().equals(staff.getStaffPos());
                }).collect(Collectors.toList());
                if (spTasks.size() > 0) {
                    Task currentTask = null;
                    int workHour = RandomUtils.nextInt(8, 12);
                    if (totoalHour.compareTo(new BigDecimal(11)) > 0) {
                        totoalHour = totoalHour.subtract(new BigDecimal(workHour));
                    } else {
                        workHour = totoalHour.intValue();
                        totoalHour = BigDecimal.ZERO;
                    }
                    boolean staffTaskEnd = false;
                    for (int i = 0; i < spTasks.size(); i++) {
                        Task task = spTasks.get(i);
                        Integer hourLeft = taskWorkHourMap.get(task.getTaskName());
                        if (hourLeft < 0) {
                            if (i != spTasks.size() - 1) {//上一任务时间耗净，下一个
                                continue;
                            } else {//所有任务时间耗净
                                staffTaskEnd = true;
                                break;
                            }
                        } else {
                            taskWorkHourMap.put(task.getTaskName(), hourLeft - workHour);
                            currentTask = task;
                        }
                    }
                    if (staffTaskEnd) {
                        continue;
                    }
                    int i = RandomUtils.nextInt(0, spTasks.size() - 1);
                    WorkDetail workDetail = new WorkDetail();

                    boolean occupied = true;//该员工时间是否已占用
                    while (HolidayUtils.isHolidayOrFestival(current) || occupied) {
                        current = DateUtils.addDays(current, 1);
                        WorkDetail queryParam = new WorkDetail();
                        queryParam.setDueDay(current)
                                .setStaffName(staff.getStaffName());
                        WorkDetail searchResult = workDetailMapper.selectSelective(queryParam);
                        if (searchResult != null) {
                            occupied = true;
                        } else {
                            occupied = false;
                        }
                    }
                    Date startTime = DateUtils.setHours(current, 9);
                    startTime = DateUtils.setMinutes(startTime, 30);
                    Date endTime = DateUtils.addHours(startTime, workHour);
                    if (workHour > 2) {
                        endTime = DateUtils.addHours(endTime, 1);
                        endTime = DateUtils.addMinutes(endTime, 30);
                    }
                    workDetail.setEndTime(endTime)
                            .setStartTime(startTime)
                            .setWorkHour(workHour)
                            .setDueDay(current)
                            .setTaskName(currentTask.getTaskName())
                            .setModule(moduleName)
                            .setStaffName(staff.getStaffName())
                            .setStaffPos(staff.getStaffPos());
                    //todo insert
                    System.out.println(JSON.toJSONString(workDetail));
                    workDetails.add(workDetail);
                    workDetailExcelModels.add(WorkDetailExcelModel.clone(workDetail));
                    workDetailMapper.insertSelective(workDetail);
                }
            }
            current = DateUtils.addDays(current, 1);

        }

        try {
            //用排序的Map且Map的键应与ExcelCell注解的index对应
            Map<String, String> map = new LinkedHashMap<>();
            map.put("id", "id");
            map.put("module", "module");
            map.put("staffName", "staffName");
            map.put("staffPos", "staffPos");
            map.put("taskName", "taskName");
            map.put("dueDay", "dueDay");
            map.put("workHour", "workHour");
            map.put("startTime", "startTime");
            map.put("endTime", "endTime");

            File f = new File("test.xls");
            OutputStream out = new FileOutputStream(f);

            ExcelUtil.exportExcel(map, workDetailExcelModels, out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
