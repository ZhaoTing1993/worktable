package cn.ting.worktable.entity;

public class Staff {
    private Integer id;

    private String staffName;

    private String staffEn;

    private String staffPos;

    private String department;

    private String module;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    public String getStaffEn() {
        return staffEn;
    }

    public void setStaffEn(String staffEn) {
        this.staffEn = staffEn == null ? null : staffEn.trim();
    }

    public String getStaffPos() {
        return staffPos;
    }

    public void setStaffPos(String staffPos) {
        this.staffPos = staffPos == null ? null : staffPos.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module == null ? null : module.trim();
    }
}