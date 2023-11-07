/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class AssignmentDTO {
    int asignment_id;
    int class_id; 
    int trainee_id;
    String submit_file;
    int mark;
    int weight;
    boolean status;
    String comment;
    Date submitTime;
    String classCode;
    int subjectId;
    String title;
    String description;

    public AssignmentDTO(int asignment_id, int class_id, int trainee_id, String submit_file, int mark, int weight, boolean status, String comment, Date submitTime, String classCode, int subjectId, String title) {
        this.asignment_id = asignment_id;
        this.class_id = class_id;
        this.trainee_id = trainee_id;
        this.submit_file = submit_file;
        this.mark = mark;
        this.weight = weight;
        this.status = status;
        this.comment = comment;
        this.submitTime = submitTime;
        this.classCode = classCode;
        this.subjectId = subjectId;
        this.title = title;
    }

    public AssignmentDTO(int asignment_id, int class_id, int trainee_id, String submit_file, int mark, int weight, boolean status, String comment, Date submitTime, String classCode, int subjectId, String title, String description) {
        this.asignment_id = asignment_id;
        this.class_id = class_id;
        this.trainee_id = trainee_id;
        this.submit_file = submit_file;
        this.mark = mark;
        this.weight = weight;
        this.status = status;
        this.comment = comment;
        this.submitTime = submitTime;
        this.classCode = classCode;
        this.subjectId = subjectId;
        this.title = title;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    

    public int getAsignment_id() {
        return asignment_id;
    }

    public void setAsignment_id(int asignment_id) {
        this.asignment_id = asignment_id;
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

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isStatus() {
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

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
}
