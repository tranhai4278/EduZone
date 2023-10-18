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
import model.Class;

/**
 *
 * @author Admin
 */
public class ClassDAO extends MySqlConnection {

    public ArrayList<Class> getAllClass() {
        ArrayList<Class> data = new ArrayList<>();
        String sql = "SELECT * FROM class";
        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();
            while (result.next()) {
                int ID = result.getInt(1);
                String Code = result.getString(2);
                int subject_ID = result.getInt(3);
                int semester_ID = result.getInt(4);
                int trainer_ID = result.getInt(5);
                boolean status = result.getBoolean(6);
                Date create_at = result.getDate(7);
                int create_by = result.getInt(8);
                Date update_at = result.getDate(9);
                int update_by = result.getInt(10);

                Class c = new Class(
                        ID,
                        Code,
                        subject_ID,
                        semester_ID,
                        trainer_ID,
                        status,
                        create_at,
                        create_by,
                        update_at,
                        update_by
                );

                data.add(c);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    public Class getClassByID(int classID) {
        String sql = "SELECT * FROM class WHERE class_id = ?";
        try {
            // Create a prepared statement to execute the SQL query
            PreparedStatement statement = connection.prepareStatement(sql);
            // Set the classID parameter in the query
            statement.setInt(1, classID);
            // Execute the query and get the result set
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                // Retrieve data from the result set
                int ID = result.getInt(1);
                String code = result.getString(2);
                int subject_ID = result.getInt(3);
                int semester_ID = result.getInt(4);
                int trainer_ID = result.getInt(5);
                boolean status = result.getBoolean(6);
                Date create_at = result.getDate(7);
                int create_by = result.getInt(8);
                Date update_at = result.getDate(9);
                int update_by = result.getInt(10);
                // Create and return a Class object with the retrieved data
                return new Class(ID, code, subject_ID, semester_ID, trainer_ID, status, create_at, create_by, update_at, update_by);
            }
        } catch (Exception e) {
            // Handle any exceptions and print an error message
            System.out.println(e.getMessage());
        }
        return null; // Return null if the class is not found
    }

    public Class getClassByCode(String classCode) {
        String sql = "SELECT * FROM class WHERE class_code = ?";
        try {
            // Create a prepared statement to execute the SQL query
            PreparedStatement statement = connection.prepareStatement(sql);
            // Set the classCode parameter in the query
            statement.setString(1, classCode);
            // Execute the query and get the result set
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                // Retrieve data from the result set
                int ID = result.getInt(1);
                String code = result.getString(2);
                int subject_ID = result.getInt(3);
                int semester_ID = result.getInt(4);
                int trainer_ID = result.getInt(5);
                boolean status = result.getBoolean(6);
                Date create_at = result.getDate(7);
                int create_by = result.getInt(8);
                Date update_at = result.getDate(9);
                int update_by = result.getInt(10);
                // Create and return a Class object with the retrieved data
                return new Class(ID, code, subject_ID, semester_ID, trainer_ID, status, create_at, create_by, update_at, update_by);
            }
        } catch (Exception e) {
            // Handle any exceptions and print an error message
            System.out.println(e.getMessage());
        }
        return null; // Return null if the class is not found
    }

    public Class getClassByTeacherName(String teacherName) {
        String sql = "SELECT c.* FROM class AS c "
                + "JOIN trainer AS t ON c.trainer_id = t.trainer_id "
                + "WHERE t.teacher_name = ?";
        try {
            // Create a prepared statement to execute the SQL query
            PreparedStatement statement = connection.prepareStatement(sql);
            // Set the teacherName parameter in the query
            statement.setString(1, teacherName);
            // Execute the query and get the result set
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                // Retrieve data from the result set
                int ID = result.getInt(1);
                String code = result.getString(2);
                int subject_ID = result.getInt(3);
                int semester_ID = result.getInt(4);
                int trainer_ID = result.getInt(5);
                boolean status = result.getBoolean(6);
                Date create_at = result.getDate(7);
                int create_by = result.getInt(8);
                Date update_at = result.getDate(9);
                int update_by = result.getInt(10);
                // Create and return a Class object with the retrieved data
                return new Class(ID, code, subject_ID, semester_ID, trainer_ID, status, create_at, create_by, update_at, update_by);
            }
        } catch (Exception e) {
            // Handle any exceptions and print an error message
            System.out.println(e.getMessage());
        }
        return null; // Return null if the class is not found
    }

    public boolean updateClass(Class updatedClass) {
        String sql = "UPDATE class SET class_code = ?, subject_id = ?, semester_id = ?, trainer_id = ?, status = ?, update_at = NOW(), update_by = ? WHERE class_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, updatedClass.getClassCode());
            preparedStatement.setInt(2, updatedClass.getSubjectID());
            preparedStatement.setInt(3, updatedClass.getSemesterID());
            preparedStatement.setInt(4, updatedClass.getTrainerID());
            preparedStatement.setBoolean(5, updatedClass.isStatus());
            preparedStatement.setInt(6, updatedClass.getUpdateBy());
            preparedStatement.setInt(7, updatedClass.getID());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addClass(Class newClass) {
        String sql = "INSERT INTO class (class_code, subject_id, semester_id, trainer_id, status, create_at, create_by, update_at, update_by) VALUES (?, ?, ?, ?, ?, NOW(), ?, NOW(), ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newClass.getClassCode());
            preparedStatement.setInt(2, newClass.getSubjectID());
            preparedStatement.setInt(3, newClass.getSemesterID());
            preparedStatement.setInt(4, newClass.getTrainerID());
            preparedStatement.setBoolean(5, newClass.isStatus());
            preparedStatement.setInt(6, newClass.getCreateBy());
            preparedStatement.setInt(7, newClass.getCreateBy());

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Class> searchClasses(String searchKeyword) {
        ArrayList<Class> data = new ArrayList<>();
        String sql = "SELECT c.* FROM class AS c "
                + "JOIN user AS u ON c.trainer_id = u.user_id "
                + "WHERE c.class_code LIKE ? OR u.full_name LIKE ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            String keyword = "%" + searchKeyword + "%";
            statement.setString(1, keyword);
            statement.setString(2, keyword);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int ID = result.getInt(1);
                String code = result.getString(2);
                int subject_ID = result.getInt(3);
                int semester_ID = result.getInt(4);
                int trainer_ID = result.getInt(5);
                boolean status = result.getBoolean(6);
                Date create_at = result.getDate(7);
                int create_by = result.getInt(8);
                Date update_at = result.getDate(9);
                int update_by = result.getInt(10);

                Class c = new Class(ID, code, subject_ID, semester_ID, trainer_ID, status, create_at, create_by, update_at, update_by);
                data.add(c);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    public ArrayList<Class> getClassesBySubject(String subjectCode) {
        ArrayList<Class> data = new ArrayList<>();
        String sql = "SELECT * FROM class WHERE subject_id = (SELECT subject_id FROM subject WHERE subject_code = ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, subjectCode);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int ID = result.getInt(1);
                String code = result.getString(2);
                int subject_ID = result.getInt(3);
                int semester_ID = result.getInt(4);
                int trainer_ID = result.getInt(5);
                boolean status = result.getBoolean(6);
                Date create_at = result.getDate(7);
                int create_by = result.getInt(8);
                Date update_at = result.getDate(9);
                int update_by = result.getInt(10);

                Class c = new Class(ID, code, subject_ID, semester_ID, trainer_ID, status, create_at, create_by, update_at, update_by);
                data.add(c);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    public boolean activateClassByID(int classID) {
        String sql = "UPDATE class SET status = true WHERE class_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, classID);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deactivateClassByID(int classID) {
        String sql = "UPDATE class SET status = false WHERE class_id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, classID);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        ClassDAO classDAO = new ClassDAO();
        ArrayList<Class> data = classDAO.getAllClass();
//        for(Class c : data){
//            System.out.println(c.getClass_Code());
//        }

//        Class c = classDAO.getClassByCode("CS102");
//        System.out.println(c.getClass_Code() + ", " + c.getTrainer_ID());
        ArrayList<Class> searchResults = classDAO.searchClasses("H");
        for (Class c : searchResults) {
            System.out.println(c.getClassCode() + ", " + c.getTrainerID());
        }
    }
}
