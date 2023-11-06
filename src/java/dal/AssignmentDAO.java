/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

<<<<<<< HEAD
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Assignment;

/**
 *
 * @author Admin
 */
public class AssignmentDAO extends MySqlConnection {

    public ArrayList getAllAssignments() {
        ArrayList<Assignment> data = new ArrayList<>();
        String sql = "SELECT \n"
                + "    A.*,\n"
                + "    L.title ,\n"
                + "    C.class_code,\n"
                + "    U.full_name\n"
                + "FROM assignment A\n"
                + "LEFT JOIN lesson L ON A.assigment_id = L.lesson_id -- Replace 'LessonID' with the actual foreign key column in 'Assignment' table\n"
                + "LEFT JOIN class C ON A.class_id = C.class_id -- Replace 'ClassID' with the actual foreign key column in 'Assignment' table\n"
                + "LEFT JOIN user U ON A.trainee_id = U.user_id;";
        
         try {
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();
            while (result.next()) {
                int assignment_id = result.getInt(1);
                String lesson_title = result.getString(10);
                int class_id = result.getInt(2);
                String class_code = result.getString(11);
                int trainee_id = result.getInt(3);
                String trainee_name = result.getString(12);
                String submit_file = result.getString(4);
=======
import java.util.ArrayList;
import java.util.Date;
import model.AssignmentSubmit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
>>>>>>> 0a1475e33006d3657302a3c9081046ead7bccacf
                double mark = result.getDouble(5);
                int weight = result.getInt(6);
                boolean status = result.getBoolean(7);
                String comment = result.getString(8);
                Date submitTime = result.getDate(9);
<<<<<<< HEAD
                
                Assignment a = new Assignment(assignment_id, lesson_title, class_id, class_code, trainee_id, trainee_name, submit_file, mark, weight, status, comment, submitTime);
                data.add(a);
            }
         }catch(Exception e){
             System.out.println(e.getMessage());
         }
         return data;
    }
    
    
    
    public static void main(String[] args) {
        AssignmentDAO assDAO = new AssignmentDAO();
        ArrayList<Assignment> data = assDAO.getAllAssignments();
        
        for(Assignment a: data){
            System.out.println(a.getTrainee_code());
        }
    }
=======
                AssignmentSubmit a = new AssignmentSubmit(classID, classID, traineeID, file, mark, weight, status, comment, submitTime);
                list.add(a);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public String getTraineeName (int id) {
        String query = "SELECT u.full_name FROM `assignment` a JOIN user u ON a.trainee_id = u.user_id WHERE a.trainee_id = ?";
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
//        ArrayList<AssignmentSubmit> list = dao.getAllAssignment();
//         for (AssignmentSubmit a : list) {
//             System.out.println(a.getFile() + " " + a.getMark());
//         }
        dao.evaluateAssignment(9, "good job", "4", "2", "2");
    }
     
    public void evaluateAssignment (double mark, String comment, String assignId, String classId, String traineeId) {
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
    
    
            

    

>>>>>>> 0a1475e33006d3657302a3c9081046ead7bccacf
}
