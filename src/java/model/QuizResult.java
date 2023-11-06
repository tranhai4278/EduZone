package model;

import java.sql.Time;
import java.time.LocalTime;

public class QuizResult {
    private int quizResultId;
    private int userId;
    private int quizId;
    private Time totalTime;
    private int correctCount;

    public QuizResult() {
    }

    public QuizResult(int quizResultId, int userId, int quizId, Time totalTime, int correctCount) {
        this.quizResultId = quizResultId;
        this.userId = userId;
        this.quizId = quizId;
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
    
    
}
