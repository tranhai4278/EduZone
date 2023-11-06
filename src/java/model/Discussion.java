package model;

import java.time.LocalDateTime;
import java.util.Date;

public class Discussion {

    private int discussionId;
    private int subjectId;
    private int classId;
    private String title;
    private String description;
    private int userId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean status;
    private Date createAt;
    private int createBy;
    private Date updateAt;
    private int updateBy;

    private String classCode;
    private String userName;
    private String formattedStartTime;
    private String formattedEndTime;

    public Discussion() {
    }

    public Discussion(int discussionId, int subjectId, int classId, String title, String description, int userId, LocalDateTime startTime, LocalDateTime endTime, boolean status, Date createAt, int createBy, Date updateAt, int updateBy) {
        this.discussionId = discussionId;
        this.subjectId = subjectId;
        this.classId = classId;
        this.title = title;
        this.description = description;
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.createAt = createAt;
        this.createBy = createBy;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
    }

    public Discussion(int discussionId, int subjectId, String classCode, String title, String description, String userName, String formattedStartTime, String formattedEndTime, boolean status, Date createAt, int createBy, Date updateAt, int updateBy) {
        this.discussionId = discussionId;
        this.subjectId = subjectId;
        this.classCode = classCode;
        this.title = title;
        this.description = description;
        this.userName = userName;
        this.formattedStartTime = formattedStartTime;
        this.formattedEndTime = formattedEndTime;
        this.status = status;
        this.createAt = createAt;
        this.createBy = createBy;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
    }

    public int getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(int discussionId) {
        this.discussionId = discussionId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
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

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFormattedStartTime() {
        return formattedStartTime;
    }

    public void setFormattedStartTime(String formattedStartTime) {
        this.formattedStartTime = formattedStartTime;
    }

    public String getFormattedEndTime() {
        return formattedEndTime;
    }

    public void setFormattedEndTime(String formattedEndTime) {
        this.formattedEndTime = formattedEndTime;
    }

}
