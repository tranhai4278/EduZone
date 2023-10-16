/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Nết
 */
public class QuestionChoise {
    private int choiceId;
    private String choice;
    private int questionId;
    private boolean trueAnswer;

    public QuestionChoise() {
    }

    public QuestionChoise(int choiceId, String choice, int questionId, boolean trueAnswer) {
        this.choiceId = choiceId;
        this.choice = choice;
        this.questionId = questionId;
        this.trueAnswer = trueAnswer;
    }

    public int getChoiceId() {
        return choiceId;
    }

    public void setChoiceId(int choiceId) {
        this.choiceId = choiceId;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public boolean isTrueAnswer() {
        return trueAnswer;
    }

    public void setTrueAnswer(boolean trueAnswer) {
        this.trueAnswer = trueAnswer;
    }
    
}
