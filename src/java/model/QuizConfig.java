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
    private int settingId;
    private int numberOfQuestion;

    public QuizConfig() {
    }

    public QuizConfig(int quizConfigId, int quizId, int settingId, int numberOfQuestion) {
        this.quizConfigId = quizConfigId;
        this.quizId = quizId;
        this.settingId = settingId;
        this.numberOfQuestion = numberOfQuestion;
    }

    public QuizConfig(int numberOfQuestion) {
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

    public int getSettingId() {
        return settingId;
    }

    public void setSettingId(int settingId) {
        this.settingId = settingId;
    }

    public int getNumberOfQuestion() {
        return numberOfQuestion;
    }

    public void setNumberOfQuestion(int numberOfQuestion) {
        this.numberOfQuestion = numberOfQuestion;
    }

    @Override
    public String toString() {
        return "QuizConfig{" + "quizConfigId=" + quizConfigId + ", quizId=" + quizId + ", settingId=" + settingId + ", numberOfQuestion=" + numberOfQuestion + '}';
    }
}
