/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
public class Quiz {

    private int quizId;
    private String quizName;
    private int subjectId;
    private int chapterId;
    private boolean quizType;
    private int numberQuestion;
    private boolean status;
    private int quizTime;
    private Date createAt;
    private int createBy;
    private Date updateAt;
    private int updateBy;
    private Subject s;
    private SubjectSetting ss;
    private QuizConfig qc;
    private QuizResult qr;
    private int selected_anwer;
    
    public Quiz() {
    }

    public Quiz(int quizId, String quizName, int subjectId, int chapterId, boolean quizType, int numberQuestion, boolean status, int quizTime, Date createAt, int createBy, Date updateAt, int updateBy, Subject s, SubjectSetting ss) {
        this.quizId = quizId;
        this.quizName = quizName;
        this.subjectId = subjectId;
        this.chapterId = chapterId;
        this.quizType = quizType;
        this.numberQuestion = numberQuestion;
        this.status = status;
        this.quizTime = quizTime;
        this.createAt = createAt;
        this.createBy = createBy;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
        this.s = s;
        this.ss = ss;
    }

    public Quiz(int quizId, String quizName, int subjectId, int chapterId, boolean quizType, int numberQuestion, boolean status, int quizTime, Date createAt, int createBy, Date updateAt, int updateBy, Subject s, SubjectSetting ss, QuizConfig qc, QuizResult qr, int selected_anwer) {
        this.quizId = quizId;
        this.quizName = quizName;
        this.subjectId = subjectId;
        this.chapterId = chapterId;
        this.quizType = quizType;
        this.numberQuestion = numberQuestion;
        this.status = status;
        this.quizTime = quizTime;
        this.createAt = createAt;
        this.createBy = createBy;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
        this.s = s;
        this.ss = ss;
        this.qc = qc;
        this.qr = qr;
        this.selected_anwer = selected_anwer;
    }
    


    public Quiz(String quizName, int subjectId, int chapterId, boolean quizType, int numberQuestion, boolean status, int quizTime, Date createAt, int createBy, Date updateAt, int updateBy) {
        this.quizName = quizName;
        this.subjectId = subjectId;
        this.chapterId = chapterId;
        this.quizType = quizType;
        this.numberQuestion = numberQuestion;
        this.status = status;
        this.quizTime = quizTime;
        this.createAt = createAt;
        this.createBy = createBy;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
    }

    public Quiz(int quizId, String quizName, int subjectId, int chapterId, boolean quizType, int numberQuestion, boolean status, int quizTime, Date createAt, int createBy, Date updateAt, int updateBy) {
        this.quizId = quizId;
        this.quizName = quizName;
        this.subjectId = subjectId;
        this.chapterId = chapterId;
        this.quizType = quizType;
        this.numberQuestion = numberQuestion;
        this.status = status;
        this.quizTime = quizTime;
        this.createAt = createAt;
        this.createBy = createBy;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
    }
    
    

    public Quiz(int quizId, String quizName, int subjectId, int chapterId, boolean quizType, int numberQuestion, boolean status, int quizTime, Date createAt, int createBy, Date updateAt, int updateBy, Subject s, SubjectSetting ss, QuizConfig qc, QuizResult qr) {
        this.quizId = quizId;
        this.quizName = quizName;
        this.subjectId = subjectId;
        this.chapterId = chapterId;
        this.quizType = quizType;
        this.numberQuestion = numberQuestion;
        this.status = status;
        this.quizTime = quizTime;
        this.createAt = createAt;
        this.createBy = createBy;
        this.updateAt = updateAt;
        this.updateBy = updateBy;
        this.s = s;
        this.ss = ss;
        this.qc = qc;
        this.qr = qr;
    }

    public Quiz(int quizId, String quizName, SubjectSetting ss, QuizConfig qc, QuizResult qr) {
        this.quizId = quizId;
        this.quizName = quizName;
        this.ss = ss;
        this.qc = qc;
        this.qr = qr;
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

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getQuizTime() {
        return quizTime;
    }

    public void setQuizTime(int quizTime) {
        this.quizTime = quizTime;
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

    public Subject getS() {
        return s;
    }

    public void setS(Subject s) {
        this.s = s;
    }

    public SubjectSetting getSs() {
        return ss;
    }

    public void setSs(SubjectSetting ss) {
        this.ss = ss;
    }

    public QuizConfig getQc() {
        return qc;
    }

    public void setQc(QuizConfig qc) {
        this.qc = qc;
    }

    public QuizResult getQr() {
        return qr;
    }

    public void setQr(QuizResult qr) {
        this.qr = qr;
    }

    @Override
    public String toString() {
        return "Quiz{" + "quizId=" + quizId + ", quizName=" + quizName + ", subjectId=" + subjectId + ", chapterId=" + chapterId + ", quizType=" + quizType + ", numberQuestion=" + numberQuestion + ", status=" + status + ", quizTime=" + quizTime + ", createAt=" + createAt + ", createBy=" + createBy + ", updateAt=" + updateAt + ", updateBy=" + updateBy + ", s=" + s + ", ss=" + ss + ", qc=" + qc + ", qr=" + qr + '}';
    }

    
}
