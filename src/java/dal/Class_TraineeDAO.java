/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Class_Trainee;
import DTO.StudentListDTO;

/**
 *
 * @author Admin
 */
public class Class_TraineeDAO extends MySqlConnection {

    public ArrayList<Class_Trainee> getAllTrainees() {
        ArrayList<Class_Trainee> data = new ArrayList<>();
        String sql = "SELECT * FROM class_student";
        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();
            while (result.next()) {
                int ID = result.getInt(1);
                int trainee_ID = result.getInt(2);
                Class_Trainee c = new Class_Trainee(ID, trainee_ID);
                data.add(c);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    public ArrayList<Class_Trainee> getTraineesByClassID(int classID) {
        ArrayList<Class_Trainee> data = new ArrayList<>();
        String sql = "SELECT * FROM class_student WHERE class_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, classID);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int ID = result.getInt(1);
                int trainee_ID = result.getInt(2);
                Class_Trainee c = new Class_Trainee(ID, trainee_ID);
                data.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    public boolean addTrainees(int classID, int traineeID) {
        String sql = "INSERT INTO class_student (class_id, trainee_id) VALUES (?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, classID);
            statement.setInt(2, traineeID);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean removeTrainees(int classID, int traineeID) {
        String sql = "DELETE FROM class_student WHERE class_id = ? AND trainee_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, classID);
            statement.setInt(2, traineeID);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public ArrayList<Class_Trainee> getClassesByTraineeID(int traineeID) {
        ArrayList<Class_Trainee> data = new ArrayList<>();
        String sql = "SELECT * FROM class_student WHERE trainee_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, traineeID);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int ID = result.getInt(1);
                int classID = result.getInt(2);
                Class_Trainee c = new Class_Trainee(ID, classID);
                data.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    public ArrayList getTraineeDTO() {
        ArrayList<StudentListDTO> data = new ArrayList<>();
        String sql = "SELECT u.user_id, u.full_name,u.email,u.phone_number ,cs.class_id, cs.trainee_id FROM user u LEFT JOIN class_student cs ON u.user_id = cs.trainee_id WHERE u.role_id = 4 ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int user_id = result.getInt(1);
                String full_name = result.getString(2);
                String email = result.getString(3);
                String phone = result.getString(4);
                int class_id = result.getInt(5);
                int trainee_id = result.getInt(6);

                Class_Trainee c = new Class_Trainee(class_id, trainee_id);
                StudentListDTO s = new StudentListDTO(user_id, full_name, email, phone, c);
                data.add(s);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    public ArrayList<StudentListDTO> getClassTraineeDTO(int targetClassId) {
        ArrayList<StudentListDTO> data = new ArrayList<>();
        String sql = "SELECT u.user_id, u.full_name, u.email, u.phone_number,cs.class_id, cs.trainee_id "
                + "FROM user u "
                + "LEFT JOIN class_student cs ON u.user_id = cs.trainee_id "
                + "WHERE u.role_id = 4 AND cs.class_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, targetClassId);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int user_id = result.getInt(1);
                String full_name = result.getString(2);
                String email = result.getString(3);
                String phone = result.getString(4);
                int class_id = result.getInt(5);
                int trainee_id = result.getInt(6);

                Class_Trainee c = new Class_Trainee(class_id, trainee_id);
                StudentListDTO s = new StudentListDTO(user_id, full_name, email, phone ,c);
                data.add(s);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data;
    }
    
    public ArrayList<StudentListDTO> searchStudentsByName(int classID, String searchTerm) {
    ArrayList<StudentListDTO> data = new ArrayList<>();
    String sql = "SELECT u.user_id, u.full_name, u.email, u.phone_number, cs.class_id, cs.trainee_id "
            + "FROM user u "
            + "LEFT JOIN class_student cs ON u.user_id = cs.trainee_id "
            + "WHERE u.role_id = 4 AND cs.class_id = ? AND u.full_name LIKE ?";
    try {
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, classID);
        statement.setString(2, "%" + searchTerm + "%"); 
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            int user_id = result.getInt(1);
            String full_name = result.getString(2);
            String email = result.getString(3);
            String phone = result.getString(4);
            int class_id = result.getInt(5);
            int trainee_id = result.getInt(6);

            Class_Trainee c = new Class_Trainee(class_id, trainee_id);
            StudentListDTO s = new StudentListDTO(user_id, full_name, email, phone, c);
            data.add(s);
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return data;
}


    public static void main(String[] args) {
        Class_TraineeDAO classTDAO = new Class_TraineeDAO();
        ArrayList<StudentListDTO> data = classTDAO.searchStudentsByName(1, "Ng");

        for (StudentListDTO c : data) {
            System.out.println(c.getPhone());
        }
    }
}
