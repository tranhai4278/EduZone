package model;

import java.sql.Time;
import java.sql.Timestamp;



public class QuizResult {
    private int quizResultId;
    private int userId;
    private int quizId;
    private Timestamp startTime;
    private Time totalTime;
    private int correctCount;

    public QuizResult() {
    }

    public QuizResult(int quizResultId, int userId, int quizId, Timestamp startTime, Time totalTime, int correctCount) {
        this.quizResultId = quizResultId;
        this.userId = userId;
        this.quizId = quizId;
        this.startTime = startTime;
        this.totalTime = totalTime;
        this.correctCount = correctCount;
    }

    public QuizResult(Timestamp startTime, Time totalTime, int correctCount) {
        this.startTime = startTime;
        this.totalTime = totalTime;
        this.correctCount = correctCount;
    }

    public QuizResult(int userId, int quizId, Timestamp startTime, Time totalTime, int correctCount) {
        this.userId = userId;
        this.quizId = quizId;
        this.startTime = startTime;
        this.totalTime = totalTime;
        this.correctCount = correctCount;
    }
    
    

    public int getQuizResultId() {
        return quizResultId;
    }

    public void setQuizResultId(int quizResultId) {
        this.quizResultId = quizResultId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Time getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Time totalTime) {
        this.totalTime = totalTime;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public void setCorrectCount(int correctCount) {
        this.correctCount = correctCount;
    }

    @Override
    public String toString() {
        return "QuizResult{" + "quizResultId=" + quizResultId + ", userId=" + userId + ", quizId=" + quizId + ", startTime=" + startTime + ", totalTime=" + totalTime + ", correctCount=" + correctCount + '}';
    }

    public void setFormattedStartTime(String format) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
    
}
