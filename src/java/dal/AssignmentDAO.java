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

/**
 *
 * @author PHAM NGOC
 */
public class AssignmentDAO extends MySqlConnection {
    public ArrayList getAllAssignment() {
        ArrayList<AssignmentSubmit> list = new ArrayList<>();
        String sql = "select * from assignment";
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
                AssignmentSubmit a = new AssignmentSubmit();
                list.add(a);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
