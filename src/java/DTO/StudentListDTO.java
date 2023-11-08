/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;
import model.Class_Trainee;
/**
 *
 * @author Admin
 */
public class StudentListDTO {
    int userID;
    String fullName;
    String email;
    String phone;
    Class_Trainee student;

    public StudentListDTO(int userID, String fullName,String email,String phone,Class_Trainee student) {
        this.userID = userID;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.student = student;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Class_Trainee getStudent() {
        return student;
    }

    public void setStudent(Class_Trainee student) {
        this.student = student;
    }
    
    
}
