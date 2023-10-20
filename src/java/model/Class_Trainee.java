/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Class_Trainee;
/**
 *
 * @author Admin
 */
public class Class_Trainee {
    
    int ClassID;
    int TraineeID;
    
    public Class_Trainee(){}

    public Class_Trainee(int ClassID, int TraineeID) {
        this.ClassID = ClassID;
        this.TraineeID = TraineeID;
    }

    public int getClassID() {
        return ClassID;
    }

    public void setClass_ID(int Class_ID) {
        this.ClassID = ClassID;
    }

    public int getTraineeID() {
        return TraineeID;
    }

    public void setTraineeID(int TraineeID) {
        this.TraineeID = TraineeID;
    }
    
    
}
