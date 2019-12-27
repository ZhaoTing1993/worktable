package cn.ting.worktable.entity;

public class Task {
    private Integer id;

    private String taskName;

    private Integer weight;

    private String module;

    private String staffPos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module == null ? null : module.trim();
    }

    public String getStaffPos() {
        return staffPos;
    }

    public void setStaffPos(String staffPos) {
        this.staffPos = staffPos == null ? null : staffPos.trim();
    }
}