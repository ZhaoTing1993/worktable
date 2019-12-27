package cn.ting.worktable.model;

import cn.ting.worktable.entity.WorkDetail;
import cn.ting.worktable.util.excel.ExcelCell;

import java.text.SimpleDateFormat;
import java.util.Date;

public class WorkDetailExcelModel {
    @ExcelCell(index = 0)
    private Integer id;

    @ExcelCell(index = 1)
    private String module;

    @ExcelCell(index = 2)
    private String staffName;

    @ExcelCell(index = 3)
    private String staffPos;

    @ExcelCell(index = 4)
    private String taskName;

    @ExcelCell(index = 5)
    private Date dueDay;

    @ExcelCell(index = 6)
    private Integer workHour;

    @ExcelCell(index = 7)
    private String startTime;

    @ExcelCell(index = 8)
    private String endTime;

    public static WorkDetailExcelModel clone(WorkDetail workDetail) {
        WorkDetailExcelModel workDetailExcelModel = new WorkDetailExcelModel()
                .setModule(workDetail.getModule())
                .setWorkHour(workDetail.getWorkHour())
                .setDueDay(workDetail.getDueDay())
                .setStaffName(workDetail.getStaffName())
                .setStaffPos(workDetail.getStaffPos())
                .setTaskName(workDetail.getTaskName())
                .setStartTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(workDetail.getStartTime()))
                .setEndTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(workDetail.getEndTime()));
        return workDetailExcelModel;
    }

    public Integer getId() {
        return id;
    }

    public WorkDetailExcelModel setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getModule() {
        return module;
    }

    public WorkDetailExcelModel setModule(String module) {
        this.module = module;
        return this;
    }

    public String getStaffName() {
        return staffName;
    }

    public WorkDetailExcelModel setStaffName(String staffName) {
        this.staffName = staffName;
        return this;
    }

    public String getStaffPos() {
        return staffPos;
    }

    public WorkDetailExcelModel setStaffPos(String staffPos) {
        this.staffPos = staffPos;
        return this;
    }

    public String getTaskName() {
        return taskName;
    }

    public WorkDetailExcelModel setTaskName(String taskName) {
        this.taskName = taskName;
        return this;
    }

    public Date getDueDay() {
        return dueDay;
    }

    public WorkDetailExcelModel setDueDay(Date dueDay) {
        this.dueDay = dueDay;
        return this;
    }

    public Integer getWorkHour() {
        return workHour;
    }

    public WorkDetailExcelModel setWorkHour(Integer workHour) {
        this.workHour = workHour;
        return this;
    }

    public String getStartTime() {
        return startTime;
    }

    public WorkDetailExcelModel setStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public String getEndTime() {
        return endTime;
    }

    public WorkDetailExcelModel setEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }
}
