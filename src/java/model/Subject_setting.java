package model;

import java.util.Date;

public class Subject_setting {
    private int settingId;
    private int subjectId;
    private int settingGroup;
    private String settingName;
    private int settingValue;
    private int displayOrder;
    private String description;
    private Date createBy;
    private int createAt;
    private Date updateAt;
    private int updateBy;

    public Subject_setting() {
    }

    public Subject_setting(int settingId, int subjectId, int settingGroup, String settingName, int settingValue, int displayOrder, String description, Date createBy, int createAt, Date updateAt, int updateBy) {
        this.settingId = settingId;
        this.subjectId = subjectId;
        this.settingGroup = settingGroup;
        this.settingName = settingName;
        this.settingValue = settingValue;
        this.displayOrder = displayOrder;
        this.description = description;
        this.createBy = createBy;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
    }

    public int getSettingId() {
        return settingId;
    }

    public void setSettingId(int settingId) {
        this.settingId = settingId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getSettingGroup() {
        return settingGroup;
    }

    public void setSettingGroup(int settingGroup) {
        this.settingGroup = settingGroup;
    }

    public String getSettingName() {
        return settingName;
    }

    public void setSettingName(String settingName) {
        this.settingName = settingName;
    }

    public int getSettingValue() {
        return settingValue;
    }

    public void setSettingValue(int settingValue) {
        this.settingValue = settingValue;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Date createBy) {
        this.createBy = createBy;
    }

    public int getCreateAt() {
        return createAt;
    }

    public void setCreateAt(int createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public int getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(int updateBy) {
        this.updateBy = updateBy;
    }

   
}
