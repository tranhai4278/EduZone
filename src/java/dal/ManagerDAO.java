/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.Subject;
import model.SubjectSetting;

/**
 *
 * @author Nết
 */
public class ManagerDAO extends MySqlConnection {

    public List<Subject> getAllSubjectbyManager(int id) {
        List<Subject> list = new ArrayList<>();
        String sql = " SELECT s.* FROM subject s, user u WHERE u.user_id = s.manager_id and s.manager_id=? and s.status = 1";
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

    public List<SubjectSetting> getChapterbySubject(int sid) {
        List<SubjectSetting> list = new ArrayList<>();
        String sql = " SELECT * FROM `subject_setting` WHERE setting_type='Chapter' and subject_id = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, sid);
            result = statement.executeQuery();
            while (result.next()) {
                SubjectSetting s = new SubjectSetting(result.getInt(1),
                        result.getInt(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getInt(6),
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

    public List<SubjectSetting> getDimensionbySubject(int sid) {
        List<SubjectSetting> list = new ArrayList<>();
        String sql = " SELECT * FROM `subject_setting` WHERE setting_type!='Chapter' and subject_id = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, sid);
            result = statement.executeQuery();
            while (result.next()) {
                SubjectSetting s = new SubjectSetting(result.getInt(1),
                        result.getInt(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getInt(6),
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

    public void updateSatusSubjectSetting(int sid, boolean status) {
        String sql = "UPDATE subject_setting SET status = ?\n"
                + "WHERE setting_id = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setBoolean(1, status);
            statement.setInt(2, sid);
            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public void addSubjectSetting(SubjectSetting s) {
        String sql = "INSERT INTO `subject_setting`"
                + "(`subject_id`, `setting_type`, `setting_name`, `description`, `display_order`, `status`, `create_at`, `create_by`, `update_at`, `update_by`) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, s.getSubjectId());
            statement.setString(2, s.getSettingType());
            statement.setString(3, s.getSettingName());
            statement.setString(4, s.getDescription());
            statement.setInt(5, s.getDisplayOrder());
            statement.setBoolean(6, s.isStatus());
            statement.setTimestamp(7, new Timestamp(s.getUpdateAt().getTime()));
            statement.setInt(8, s.getUpdateBy());
            statement.setTimestamp(9, new Timestamp(s.getCreateAt().getTime()));
            statement.setInt(10, s.getUpdateBy());
            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public SubjectSetting checkSettingNameinGroup(int sid, String name, String type) {
        SubjectSetting p = null;
        String sql = "SELECT * FROM subject_setting WHERE setting_name = N? AND setting_type = N? AND subject_id =?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, type);
            statement.setInt(3, sid);
            result = statement.executeQuery();
            while (result.next()) {
                p = new SubjectSetting(
                        result.getInt(1),
                        result.getInt(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getInt(6),
                        result.getBoolean(7),
                        result.getDate(8),
                        result.getInt(9),
                        result.getDate(10),
                        result.getInt(11));
            }
        } catch (SQLException e) {

        }
        return p;
    }

    public SubjectSetting getSubjectSeting(int sid) {
        SubjectSetting p = null;
        String sql = "SELECT * FROM `subject_setting` WHERE setting_id=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, sid);
            result = statement.executeQuery();
            while (result.next()) {
                p = new SubjectSetting(
                        result.getInt(1),
                        result.getInt(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getInt(6),
                        result.getBoolean(7),
                        result.getDate(8),
                        result.getInt(9),
                        result.getDate(10),
                        result.getInt(11));
            }
        } catch (SQLException e) {

        }
        return p;
    }

    public void editDimension(SubjectSetting s) {
        String sql = "UPDATE `subject_setting` "
                + "SET `setting_type`=?,"
                + "`setting_name`=?,"
                + "`description`=?,"
                + "`display_order`=?,"
                + "`status`=?,"
                + "`update_at`=?,"
                + "`update_by`=? \n"
                + "WHERE `setting_id`=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, s.getSettingType());
            statement.setString(2, s.getSettingName());
            statement.setString(3, s.getDescription());
            statement.setInt(4, s.getDisplayOrder());
            statement.setBoolean(5, s.isStatus());
            statement.setTimestamp(6, new Timestamp(s.getUpdateAt().getTime()));
            statement.setInt(7, s.getUpdateBy());
            statement.setInt(8, s.getSettingId());
            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public SubjectSetting checkSettingEditNameinGroup(int id, int sid, String name, String type) {
        SubjectSetting p = null;
        String sql = "SELECT * FROM subject_setting WHERE setting_name = N? AND setting_type = N? AND subject_id =? AND `setting_id`!=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, type);
            statement.setInt(3, sid);
            statement.setInt(4, id);

            result = statement.executeQuery();
            while (result.next()) {
                p = new SubjectSetting(
                        result.getInt(1),
                        result.getInt(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5),
                        result.getInt(6),
                        result.getBoolean(7),
                        result.getDate(8),
                        result.getInt(9),
                        result.getDate(10),
                        result.getInt(11));
            }
        } catch (SQLException e) {

        }
        return p;
    }
}
