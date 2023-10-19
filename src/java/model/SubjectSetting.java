package model;

import java.util.Date;


/**
 *
 * @author Nết
 */
public class SubjectSetting {


    private int settingId;
    private int subjectId;
    private int settingType;
    private String settingName;
    private String description;
    private int displayOrder;
    private boolean status;
    private Date createAt;
    private int createBy;
    private Date updateAt;
    private int updateBy;

    public SubjectSetting() {
    }

    public SubjectSetting(int settingId, int subjectId, int settingType, String settingName, String description, int displayOrder, boolean status, Date createAt, int createBy, Date updateAt, int updateBy) {
        this.settingId = settingId;
        this.subjectId = subjectId;
        this.settingType = settingType;
        this.settingName = settingName;
        this.description = description;
        this.displayOrder = displayOrder;
        this.status = status;
        this.createAt = createAt;
        this.createBy = createBy;
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

    public int getSettingType() {
        return settingType;
    }

    public void setSettingType(int settingType) {
        this.settingType = settingType;
    }

    public String getSettingName() {
        return settingName;
    }

    public void setSettingName(String settingName) {
        this.settingName = settingName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public int getCreateBy() {
        return createBy;
    }

    public void setCreateBy(int createBy) {
        this.createBy = createBy;
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