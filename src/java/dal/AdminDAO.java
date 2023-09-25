/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.Subject;
import model.User;

/**
 *
 * @author Nết
 */
public class AdminDAO extends MySqlConnection {

    public List<Subject> getAllSubject() {
        List<Subject> list = new ArrayList<>();
        String sql = " SELECT * FROM subject";
        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();
            while (result.next()) {
                Subject s = new Subject(result.getInt(1),
                        result.getInt(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getBoolean(7),
                        result.getDate(8),
                        result.getInt(9),
                        result.getDate(10),
                        result.getInt(11)
                );
                list.add(s);
            }
        } catch (SQLException e) {

        }
        return list;
    }

    public Subject getSubjectbyId(String id) {
        Subject p = null;
        String sql = "SELECT s.*,u.user_id,u.full_name,u.role_id FROM subject s, user u WHERE subject_id = ? AND s.manager_id=u.user_id";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            result = statement.executeQuery();
            while (result.next()) {
                p = new Subject(result.getInt(1),
                        result.getInt(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getString(6),
                        result.getBoolean(7),
                        result.getDate(8),
                        result.getInt(9),
                        result.getDate(10),
                        result.getInt(11)
                );
                p.setU(new User(result.getInt(12), result.getString(13), result.getInt(14)));
            }
        } catch (SQLException e) {

        }
        return p;
    }

    public List<User> getAllSubManager() {
        List<User> list = new ArrayList<>();
        String sql = " SELECT u.user_id,u.full_name,u.role_id\n"
                + "FROM user u, setting s\n"
                + "WHERE u.role_id=s.setting_id and s.setting_group=1 AND (s.setting_id=2 OR s.setting_id=1 ) and u.status=1";
        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();
            while (result.next()) {
                User s = new User(result.getInt(1), result.getString(2), result.getInt(3));

                list.add(s);
            }
        } catch (SQLException e) {

        }
        return list;
    }

    public void editSubject(Subject s) {
        String sql = "UPDATE `subject` \n"
                + "SET\n"
                + "`manager_id`=?,\n"
                + "`subject_name`=?,\n"
                + "`subject_code`=?,\n"
                + "`description`=?,\n"
                + "`img_url`=?,\n"
                + "`status`=?,\n"
                + "`update_at`=?,\n"
                + "`update_by`=? \n"
                + "WHERE subject_id =?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, s.getManagerId());
            statement.setString(2, s.getSubjectName());
            statement.setString(3, s.getSubjectCode());
            statement.setString(4, s.getDescription());
            statement.setString(5, s.getImgUrl());
            statement.setBoolean(6, s.isStatus());
            statement.setTimestamp(7, new Timestamp(s.getUpdateAt().getTime()));
            statement.setInt(8, s.getUpdateBy());
            statement.setInt(9, s.getSubjectId());
            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public void updateSatus(int sid, boolean status) {
        String sql = "UPDATE `subject` SET`status`=?\n"
                + "WHERE subject_id = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setBoolean(1, status);
            statement.setInt(2, sid);
            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }

}
