package model;

import java.time.LocalDateTime;

public class Assignment {
    private int assignmentId;
    private int classId;
    private int traineeId;
    private String submitFile;
    private double mark;
    private int weight;
    private boolean status;
    private int comment;
    private LocalDateTime submitTime;

    public Assignment() {
    }

    public Assignment(int assignmentId, int classId, int traineeId, String submitFile, double mark, int weight, boolean status, int comment, LocalDateTime submitTime) {
        this.assignmentId = assignmentId;
        this.classId = classId;
        this.traineeId = traineeId;
        this.submitFile = submitFile;
        this.mark = mark;
        this.weight = weight;
        this.status = status;
        this.comment = comment;
        this.submitTime = submitTime;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getTraineeId() {
        return traineeId;
    }

    public void setTraineeId(int traineeId) {
        this.traineeId = traineeId;
    }

    public String getSubmitFile() {
        return submitFile;
    }

    public void setSubmitFile(String submitFile) {
        this.submitFile = submitFile;
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

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public LocalDateTime getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(LocalDateTime submitTime) {
        this.submitTime = submitTime;
    }
    
    
}
