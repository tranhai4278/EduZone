/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Assignment {
    int assignment_id;
    String lesson_title;
    int class_id;
    String class_code;
    int trainee_id;
    String trainee_code;
    String submit_file;
    double mark;
    int weight;
    boolean status;
    String comment;
    Date submit_time;

    public Assignment(int assignment_id, int class_id, int trainee_id, String submit_file, double mark, int weight, boolean status, String comment, Date submit_time) {
        this.assignment_id = assignment_id;
        this.class_id = class_id;
        this.trainee_id = trainee_id;
        this.submit_file = submit_file;
        this.mark = mark;
        this.weight = weight;
        this.status = status;
        this.comment = comment;
        this.submit_time = submit_time;
    }

    public Assignment(int assignment_id, String lesson_title, int class_id, String class_code, int trainee_id, String trainee_code, String submit_file, double mark, int weight, boolean status, String comment, Date submit_time) {
        this.assignment_id = assignment_id;
        this.lesson_title = lesson_title;
        this.class_id = class_id;
        this.class_code = class_code;
        this.trainee_id = trainee_id;
        this.trainee_code = trainee_code;
        this.submit_file = submit_file;
        this.mark = mark;
        this.weight = weight;
        this.status = status;
        this.comment = comment;
        this.submit_time = submit_time;
    }
    
    

    public int getAssignment_id() {
        return assignment_id;
    }

    public void setAssignment_id(int assignment_id) {
        this.assignment_id = assignment_id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getTrainee_id() {
        return trainee_id;
    }

    public void setTrainee_id(int trainee_id) {
        this.trainee_id = trainee_id;
    }

    public String getSubmit_file() {
        return submit_file;
    }

    public void setSubmit_file(String submit_file) {
        this.submit_file = submit_file;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public String getLesson_title() {
        return lesson_title;
    }

    public void setLesson_title(String lesson_title) {
        this.lesson_title = lesson_title;
    }

    public String getClass_code() {
        return class_code;
    }

    public void setClass_code(String class_code) {
        this.class_code = class_code;
    }

    public String getTrainee_code() {
        return trainee_code;
    }

    public void setTrainee_code(String trainee_code) {
        this.trainee_code = trainee_code;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getSubmit_time() {
        return submit_time;
    }

    public void setSubmit_time(Date submit_time) {
        this.submit_time = submit_time;
    }
    
    
}
