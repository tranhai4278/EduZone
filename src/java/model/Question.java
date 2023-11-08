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
    private int flag;
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
    private String chapter;
    private QuestionChoise qc;
    public Question() {
    }

    public Question(String question, int flag , int chapterId, int subjectId, Date createAt) {
        this.question = question;
        this.flag  = flag ;
        this.chapterId = chapterId;
        this.subjectId = subjectId;
        this.createAt = createAt;
    }

    public Question(int questionId, String question, int flag, int chapterId, int subjectId, Date createAt, int createBy, Date updateAt, int updateBy, String dimensionType, String dimensionName, String dimension, String subjectCode, String chapter, QuestionChoise qc) {
        this.questionId = questionId;
        this.question = question;
        this.flag = flag;
        this.chapterId = chapterId;
        this.subjectId = subjectId;
        this.createAt = createAt;
        this.createBy = createBy;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
        this.dimensionType = dimensionType;
        this.dimensionName = dimensionName;
        this.dimension = dimension;
        this.subjectCode = subjectCode;
        this.chapter = chapter;
        this.qc = qc;
    }
    
    

    public Question(int questionId, String question, int flag , int chapterId, int subjectId, Date createAt, int createBy, Date updateAt, int updateBy) {
        this.questionId = questionId;
        this.question = question;
        this.flag = flag ;
        this.chapterId = chapterId;
        this.subjectId = subjectId;
        this.createAt = createAt;
        this.createBy = createBy;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
    }
    
    public Question(int questionId, String question, String dimension, String subjectCode, String chapter, int flag, Date createAt) {
        this.questionId = questionId;
        this.question = question;
        this.dimension = dimension;
        this.subjectCode = subjectCode;
        this.chapter = chapter;
        this.flag = flag;
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

    public int getFlag() {
        return flag ;
    }

    public void setFlag(int flag ) {
        this.flag  = flag ;
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

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }
}
