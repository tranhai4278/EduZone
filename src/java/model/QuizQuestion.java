/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author MinhDQ
 */
public class QuizQuestion {
    private int quizId;
    private int questionId;

    public QuizQuestion() {
    }

    public QuizQuestion(int quizId, int questionId) {
        this.quizId = quizId;
        this.questionId = questionId;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    @Override
    public String toString() {
        return "QuizQuestion{" + "quizId=" + quizId + ", questionId=" + questionId + '}';
    }
    
}
