package model;

import java.util.Date;

public class Setting {
    private int settingId;
    private int settingGroup;
    private String settingName;
    private boolean status;
    private int displayOrder;
    private String note;
    private Date createAt;
    private int createBy;
    private Date updateAt;
    private int updateBy;

    public Setting() {
    }

    public Setting(int settingId, int settingGroup, String settingName, boolean status, int displayOrder, String note, Date createAt, int createBy, Date updateAt, int updateBy) {
        this.settingId = settingId;
        this.settingGroup = settingGroup;
        this.settingName = settingName;
        this.status = status;
        this.displayOrder = displayOrder;
        this.note = note;
        this.createAt = createAt;
        this.createBy = createBy;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
    }




    public Setting(int settingId, int settingGroup, String settingName, boolean status, int displayOrder, String note, Date updateAt, int updateBy) {
        this.settingId = settingId;
        this.settingGroup = settingGroup;
        this.settingName = settingName;
        this.status = status;
        this.displayOrder = displayOrder;
        this.note = note;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
    }


    public Setting(int settingGroup, String settingName, boolean status, int displayOrder, String note, Date createAt, int createBy, Date updateAt, int updateBy) {
        this.settingGroup = settingGroup;
        this.settingName = settingName;
        this.status = status;
        this.displayOrder = displayOrder;
        this.note = note;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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


    @Override
    public String toString() {
        return "Setting{" + "settingId=" + settingId + ", settingGroup=" + settingGroup + ", settingName=" + settingName + ", status=" + status + ", displayOrder=" + displayOrder + ", note=" + note + ", createAt=" + createAt + ", createBy=" + createBy + ", updateAt=" + updateAt + ", updateBy=" + updateBy + '}';
    }
}