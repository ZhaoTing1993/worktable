package cn.ting.worktable.entity;

import java.util.Date;

public class WorkDetail {
    private Integer id;

    private String module;

    private String staffName;

    private String staffPos;

    private String taskName;

    private Date dueDay;

    private Date startTime;

    private Date endTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module == null ? null : module.trim();
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    public String getStaffPos() {
        return staffPos;
    }

    public void setStaffPos(String staffPos) {
        this.staffPos = staffPos == null ? null : staffPos.trim();
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public Date getDueDay() {
        return dueDay;
    }

    public void setDueDay(Date dueDay) {
        this.dueDay = dueDay;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}