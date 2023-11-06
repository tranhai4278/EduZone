/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author PHAM NGOC
 */
public class AssignmentSubmit {
    private int aID;
    private int classID;
    private int traineeID;
    private String file;
    private double mark;
    private int weight;
    private boolean status;
    private String comment;
    private Date submitTime;

    public AssignmentSubmit() {
    }

    public AssignmentSubmit(int aID, int classID, int traineeID, String file, double mark, int weight, boolean status, String comment, Date submitTime) {
        this.aID = aID;
        this.classID = classID;
        this.traineeID = traineeID;
        this.file = file;
        this.mark = mark;
        this.weight = weight;
        this.status = status;
        this.comment = comment;
        this.submitTime = submitTime;
    }

    public int getaID() {
        return aID;
    }

    public void setaID(int aID) {
        this.aID = aID;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public int getTraineeID() {
        return traineeID;
    }

    public void setTraineeID(int traineeID) {
        this.traineeID = traineeID;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
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
    
}
