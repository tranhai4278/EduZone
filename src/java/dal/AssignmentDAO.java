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
                double mark = result.getDouble(5);
                int weight = result.getInt(6);
                boolean status = result.getBoolean(7);
                String comment = result.getString(8);
                Date submitTime = result.getDate(9);
                
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
}
