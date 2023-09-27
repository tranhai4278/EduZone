/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Nết
 */
public class Subject {

    private int subjectId;
    private int managerId;
    private String managerName;
    private String subjectName;
    private String subjectCode;
    private String description;
    private String imgUrl;
    private boolean status;
    private Date createAt;
    private int createBy;
    private Date updateAt;
    private int updateBy;
    private User u;

    public Subject() {
    }

    public Subject(int subjectId, int managerId, String managerName, String subjectName, String subjectCode, String description, String imgUrl, boolean status, Date createAt, int createBy, Date updateAt, int updateBy) {
        this.subjectId = subjectId;
        this.managerId = managerId;
        this.managerName = managerName;
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.description = description;
        this.imgUrl = imgUrl;
        this.status = status;
        this.createAt = createAt;
        this.createBy = createBy;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
    }

    public Subject(int subjectId, int managerId, String subjectName, String subjectCode, String description, String imgUrl, boolean status, Date createAt, int createBy, Date updateAt, int updateBy) {
        this.subjectId = subjectId;
        this.managerId = managerId;
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.description = description;
        this.imgUrl = imgUrl;
        this.status = status;
        this.createAt = createAt;
        this.createBy = createBy;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
    }

    public Subject(int subjectId, int managerId, String subjectName, String subjectCode, String description, String imgUrl, boolean status, Date updateAt, int updateBy) {
        this.subjectId = subjectId;
        this.managerId = managerId;
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.description = description;
        this.imgUrl = imgUrl;
        this.status = status;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
    }
    

    public Subject(int subjectId, int managerId, String subjectName, String subjectCode, String description, String imgUrl, boolean status, Date createAt, int createBy, Date updateAt, int updateBy, User u) {
        this.subjectId = subjectId;
        this.managerId = managerId;
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
        this.description = description;
        this.imgUrl = imgUrl;
        this.status = status;
        this.createAt = createAt;
        this.createBy = createBy;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
        this.u = u;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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
