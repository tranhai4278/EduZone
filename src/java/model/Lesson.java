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
public class Lesson {
    private int lessonId;
    private String title;
    private int chapterId;
    private int classId;
    private String lessonType;
    private int quizId;
    private String videoLink;
    private String file;
    private boolean status;
    private String description;
    private Date startDate;
    private Date endDate;
    private int displayOrder;
    private Date createAt;
    private int createBy;
    private Date updateAt;
    private int updateBy;

    public Lesson() {
    }

    public Lesson(int lessonId, String title, int chapterId, int classId, String lessonType, int quizId, String videoLink, String file, boolean status, String description, Date startDate, Date endDate, int displayOrder, Date createAt, int createBy, Date updateAt, int updateBy) {
        this.lessonId = lessonId;
        this.title = title;
        this.chapterId = chapterId;
        this.classId = classId;
        this.lessonType = lessonType;
        this.quizId = quizId;
        this.videoLink = videoLink;
        this.file = file;
        this.status = status;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.displayOrder = displayOrder;
        this.createAt = createAt;
        this.createBy = createBy;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
    }
    
    

    public Lesson(int lessonId, String title, int chapterId, int classId, String lessonType, int quizId, String videoLink, String file, boolean status, String description, Date createAt, int createBy, Date updateAt, int updateBy) {
        this.lessonId = lessonId;
        this.title = title;
        this.chapterId = chapterId;
        this.classId = classId;
        this.lessonType = lessonType;
        this.quizId = quizId;
        this.videoLink = videoLink;
        this.file = file;
        this.status = status;
        this.description = description;
        this.createAt = createAt;
        this.createBy = createBy;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getLessonType() {
        return lessonType;
    }

    public void setLessonType(String lessonType) {
        this.lessonType = lessonType;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
