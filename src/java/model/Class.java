/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Class {
    private int ID; 
    private String classCode; 
    private int SubjectID;
    private int SemesterID;
    private int TrainerID;
    private boolean Status;
    private Date CreateAt;
    private int CreateBy; 
    private Date UpdateAt;
    private int UpdateBy;
   
    public Class(){}

    public Class(int ID, String classCode, int SubjectID, int SemesterID,int TrainerID, boolean Status, Date CreateAt, int CreateBy, Date UpdateAt, int UpdateBy) {
        this.ID = ID;
        this.classCode = classCode;
        this.SubjectID = SubjectID;
        this.SemesterID = SemesterID;
        this.TrainerID = TrainerID;
        this.Status = Status;
        this.CreateAt = CreateAt;
        this.CreateBy = CreateBy;
        this.UpdateAt = UpdateAt;
        this.UpdateBy = UpdateBy;
    }

    public Class(String classCode, int SubjectID, int SemesterID, int TrainerID, boolean Status, int CreateBy) {
        this.classCode = classCode;
        this.SubjectID = SubjectID;
        this.SemesterID = SemesterID;
        this.TrainerID = TrainerID;
        this.Status = Status;
        this.CreateBy = CreateBy;
    }

    
    
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getclassCode() {
        return classCode;
    }

    public void setclassCode(String classCode) {
        this.classCode = classCode;
    }

    public int getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(int SubjectID) {
        this.SubjectID = SubjectID;
    }

    public int getSemesterID() {
        return SemesterID;
    }

    public void setSemesterID(int SemesterID) {
        this.SemesterID = SemesterID;
    }

    public int getTrainerID() {
        return TrainerID;
    }

    public void setTrainerID(int TrainerID) {
        this.TrainerID = TrainerID;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public Date getCreateAt() {
        return CreateAt;
    }

    public void setCreateAt(Date CreateAt) {
        this.CreateAt = CreateAt;
    }

    public int getCreateBy() {
        return CreateBy;
    }

    public void setCreateBy(int CreateBy) {
        this.CreateBy = CreateBy;
    }

    public Date getUpdateAt() {
        return UpdateAt;
    }

    public void setUpdateAt(Date UpdateAt) {
        this.UpdateAt = UpdateAt;
    }

    public int getUpdateBy() {
        return UpdateBy;
    }

    public void setUpdateBy(int UpdateBy) {
        this.UpdateBy = UpdateBy;
    }

   
    
    
}



