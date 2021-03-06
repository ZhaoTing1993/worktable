package cn.ting.worktable.entity;

import cn.ting.worktable.util.excel.ExcelCell;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class WorkDetail {
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
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    @ExcelCell(index = 8)
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    public Integer getId() {
        return id;
    }

    public WorkDetail setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getModule() {
        return module;
    }

    public WorkDetail setModule(String module) {
        this.module = module;
        return this;
    }

    public String getStaffName() {
        return staffName;
    }

    public WorkDetail setStaffName(String staffName) {
        this.staffName = staffName;
        return this;
    }

    public String getStaffPos() {
        return staffPos;
    }

    public WorkDetail setStaffPos(String staffPos) {
        this.staffPos = staffPos;
        return this;
    }

    public String getTaskName() {
        return taskName;
    }

    public WorkDetail setTaskName(String taskName) {
        this.taskName = taskName;
        return this;
    }

    public Date getDueDay() {
        return dueDay;
    }

    public WorkDetail setDueDay(Date dueDay) {
        this.dueDay = dueDay;
        return this;
    }

    public Integer getWorkHour() {
        return workHour;
    }

    public WorkDetail setWorkHour(Integer workHour) {
        this.workHour = workHour;
        return this;
    }

    public Date getStartTime() {
        return startTime;
    }

    public WorkDetail setStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public Date getEndTime() {
        return endTime;
    }

    public WorkDetail setEndTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }
}