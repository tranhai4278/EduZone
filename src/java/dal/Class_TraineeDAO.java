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

    public static void main(String[] args) {
        Class_TraineeDAO classTDAO = new Class_TraineeDAO();
        ArrayList<Class_Trainee> data = classTDAO.getAllTrainees();

        for (Class_Trainee c : data) {
            System.out.println(c.getClassID() + "' " + c.getTraineeID());
        }
    }
}
