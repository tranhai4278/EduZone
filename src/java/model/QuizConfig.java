/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MinhDQ
 */
public class QuizConfig {
    private int quizConfigId;
    private int quizId;
    private int dimentionId;
    private int chapterId;
    private int numberOfQuestion;

    public QuizConfig() {
    }

    public QuizConfig(int quizConfigId, int quizId, int dimentionId, int chapterId, int numberOfQuestion) {
        this.quizConfigId = quizConfigId;
        this.quizId = quizId;
        this.dimentionId = dimentionId;
        this.chapterId = chapterId;
        this.numberOfQuestion = numberOfQuestion;
    }

    public int getQuizConfigId() {
        return quizConfigId;
    }

    public void setQuizConfigId(int quizConfigId) {
        this.quizConfigId = quizConfigId;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public int getDimentionId() {
        return dimentionId;
    }

    public void setDimentionId(int dimentionId) {
        this.dimentionId = dimentionId;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public int getNumberOfQuestion() {
        return numberOfQuestion;
    }

    public void setNumberOfQuestion(int numberOfQuestion) {
        this.numberOfQuestion = numberOfQuestion;
    }

    @Override
    public String toString() {
        return "QuizConfig{" + "quizConfigId=" + quizConfigId + ", quizId=" + quizId + ", dimentionId=" + dimentionId + ", chapterId=" + chapterId + ", numberOfQuestion=" + numberOfQuestion + '}';
    }
    
}
