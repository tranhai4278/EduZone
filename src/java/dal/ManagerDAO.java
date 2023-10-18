/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Subject;
import model.User;

/**
 *
 * @author Nết
 */
public class ManagerDAO extends MySqlConnection{
        public List<Subject> getAllSubjectbyManager(int id) {
        List<Subject> list = new ArrayList<>();
        String sql = " SELECT s.* FROM subject s, user u WHERE u.user_id = s.manager_id and s.manager_id=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            result = statement.executeQuery();
            while (result.next()) {
                Subject s = new Subject(result.getInt(1),
                        result.getInt(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getBoolean(6),
                        result.getDate(7),
                        result.getInt(8),
                        result.getDate(9),
                        result.getInt(10)
                );
                list.add(s);

            }
        } catch (SQLException e) {

        }
        return list;
    }
}
