/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.Date;
import model.AssignmentSubmit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import model.Assignment;

/**
 *
 * @author PHAM NGOC
 */
public class AssignmentDAO extends MySqlConnection {

    public ArrayList getAllAssignment() {
        ArrayList<AssignmentSubmit> list = new ArrayList<>();
        String sql = "SELECT * FROM `assignment`";
        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();
            while (result.next()) {
                int assignmentID = result.getInt(1);
                int classID = result.getInt(2);
                int traineeID = result.getInt(3);
                String file = result.getString(4);
                double mark = result.getDouble(5);
                int weight = result.getInt(6);
                boolean status = result.getBoolean(7);
                String comment = result.getString(8);
                Date submitTime = result.getDate(9);
                AssignmentSubmit a = new AssignmentSubmit(classID, classID, traineeID, file, mark, weight, status, comment, submitTime);
                list.add(a);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList getAllAssignmentTrainee(int user_id) {
        ArrayList<Assignment> list = new ArrayList<>();
        String sql = "SELECT * FROM `assignment` WHERE trainee_id=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, user_id);
            result = statement.executeQuery();
            while (result.next()) {
                int assignmentID = result.getInt(1);
                int classID = result.getInt(2);
                int traineeID = result.getInt(3);
                String file = result.getString(4);
                double mark = result.getDouble(5);
                int weight = result.getInt(6);
                boolean status = result.getBoolean(7);
                String comment = result.getString(8);
                Date submitTime = result.getDate(9);
                Assignment a = new Assignment(assignmentID, classID, traineeID, file, mark, weight, status, weight, LocalDateTime.MIN);
                list.add(a);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Assignment getAssignmentDetail(int assignment_id, int class_id, int trainee_id) {

        String sql = "SELECT * FROM `assignment` WHERE assigment_id = ? AND class_id = ? AND trainee_id = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, assignment_id);
            statement.setInt(2, class_id);
            statement.setInt(3, trainee_id);
            result = statement.executeQuery();
            while (result.next()) {
                int assignmentID = result.getInt(1);
                int classID = result.getInt(2);
                int traineeID = result.getInt(3);
                String file = result.getString(4);
                double mark = result.getDouble(5);
                int weight = result.getInt(6);
                boolean status = result.getBoolean(7);
                String comment = result.getString(8);
                Date submitTime = result.getDate(9);
                Assignment a = new Assignment(assignmentID, classID, traineeID, file, mark, weight, status, weight, LocalDateTime.MIN);
                return a;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getTraineeName(int id) {
        String query = "SELECT u.full_name FROM `assigment` a JOIN user u ON a.trainee_id = u.user_id WHERE a.trainee_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return result.getString("full_name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        AssignmentDAO dao = new AssignmentDAO();
        ArrayList<Assignment> list = dao.getAllAssignmentTrainee(2);
        for (Assignment a : list) {
//        Assignment a = dao.getAssignmentDetail(4, 1, 3);
            System.out.println(a.getSubmitFile());
//         }
//            dao.evaluateAssignment(9, "good job", "4", "2", "2");

        }
    }

    public boolean submitAssignment(int assignmentId, int traineeId, int classId, String fileName) {
        String sql = "UPDATE assignment SET submit_file = ?, submitTime = ?, status = ? WHERE assigment_id = ? AND trainee_id = ? AND class_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, fileName);
            Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
            preparedStatement.setTimestamp(2, currentTimestamp);
            preparedStatement.setInt(3, 1); // Set status to 1
            preparedStatement.setInt(4, assignmentId);
            preparedStatement.setInt(5, traineeId);
            preparedStatement.setInt(6, classId);

            int rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();

            if (rowsAffected > 0) {
                return true; // The update was successful.
            } else {
                return false; // No rows were updated.
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // An error occurred during the update.
        }
    }

    public void evaluateAssignment(double mark, String comment, String assignId, String classId, String traineeId) {
        MySqlConnection dbContext = new MySqlConnection();
        try {
            String sql = "UPDATE `assignment` SET `mark`=?,`comment`=? WHERE assigment_id = ? AND class_id = ? AND trainee_id = ?";
            PreparedStatement preparedStatement = dbContext.connection.prepareStatement(sql);
            preparedStatement.setDouble(1, mark);
            preparedStatement.setString(2, comment);
            preparedStatement.setString(3, assignId);
            preparedStatement.setString(4, classId);
            preparedStatement.setString(5, traineeId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            dbContext.connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
