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
public class Quiz {
    private int quizId;
    private String quizName;
    private int subjectId;
    private Date createAt;
    private int createBy;
    private Date updateAt;
    private int updateBy;
    private boolean quizType;
    private int numberQuestion;

    public Quiz() {
    }

    public Quiz(int quizId, String quizName, int subjectId, Date createAt, int createBy, Date updateAt, int updateBy, boolean quizType, int numberQuestion) {
        this.quizId = quizId;
        this.quizName = quizName;
        this.subjectId = subjectId;
        this.createAt = createAt;
        this.createBy = createBy;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
        this.quizType = quizType;
        this.numberQuestion = numberQuestion;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
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

    public boolean isQuizType() {
        return quizType;
    }

    public void setQuizType(boolean quizType) {
        this.quizType = quizType;
    }

    public int getNumberQuestion() {
        return numberQuestion;
    }

    public void setNumberQuestion(int numberQuestion) {
        this.numberQuestion = numberQuestion;
    }

    @Override
    public String toString() {
        return "Quiz{" + "quizId=" + quizId + ", quizName=" + quizName + ", subjectId=" + subjectId + ", createAt=" + createAt + ", createBy=" + createBy + ", updateAt=" + updateAt + ", updateBy=" + updateBy + ", quizType=" + quizType + ", numberQuestion=" + numberQuestion + '}';
    }

   

    
}
