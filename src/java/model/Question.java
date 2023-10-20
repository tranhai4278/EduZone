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
public class Question {
    private int questionId;
    private String question;
    private int lessonId;
    private int chapterId;
    private int subjectId;
    private Date createAt;
    private int createBy;
    private Date updateAt;
    private int updateBy;
    
    private String dimensionType;
    private String dimensionName;
    private String dimension;
    private String subjectCode;

    public Question() {
    }

    public Question(String question, int lessonId, int chapterId, int subjectId, Date createAt) {
        this.question = question;
        this.lessonId = lessonId;
        this.chapterId = chapterId;
        this.subjectId = subjectId;
        this.createAt = createAt;
    }
    
    

    public Question(int questionId, String question, int lessonId, int chapterId, int subjectId, Date createAt, int createBy, Date updateAt, int updateBy) {
        this.questionId = questionId;
        this.question = question;
        this.lessonId = lessonId;
        this.chapterId = chapterId;
        this.subjectId = subjectId;
        this.createAt = createAt;
        this.createBy = createBy;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
    }
    
    public Question(int questionId, String question, String dimenstion, String subjectCode, Date createAt) {
        this.questionId = questionId;
        this.question = question;
        this.dimension = dimenstion;
        this.subjectCode = subjectCode;
        this.createAt = createAt;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
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

    public String getDimensionType() {
        return dimensionType;
    }

    public void setDimensionType(String dimensionType) {
        this.dimensionType = dimensionType;
    }

    public String getDimensionName() {
        return dimensionName;
    }

    public void setDimensionName(String dimensionName) {
        this.dimensionName = dimensionName;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }
    
}
