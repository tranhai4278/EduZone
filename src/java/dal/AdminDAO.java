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
import model.Setting;
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

    public void updateSatusSetting(int sid, boolean status) {
        String sql = "UPDATE setting SET status = ?\n"
                + "WHERE setting_id = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setBoolean(1, status);
            statement.setInt(2, sid);
            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public Setting getSetting(int gid, int sid) {
        Setting p = null;
        String sql = "SELECT * FROM `setting` WHERE setting_group = ? and setting_id=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, gid);
            statement.setInt(2, sid);
            result = statement.executeQuery();
            while (result.next()) {
                p = new Setting(result.getInt(1),
                        result.getInt(2),
                        result.getString(3),
                        result.getBoolean(4),
                        result.getInt(5),
                        result.getString(6),
                        result.getDate(7),
                        result.getInt(8),
                        result.getDate(9),
                        result.getInt(10));
            }
        } catch (SQLException e) {

        }
        return p;
    }

    public List<Setting> getAllSetting(int gid) {
        List<Setting> list = new ArrayList<>();
        String sql = " SELECT * FROM `setting` WHERE `setting_group`= ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, gid);
            result = statement.executeQuery();

            while (result.next()) {
                Setting s = new Setting(result.getInt(1),
                        result.getInt(2),
                        result.getString(3),
                        result.getBoolean(4),
                        result.getInt(5),
                        result.getString(6),
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

    public void editSetting(Setting s) {
        String sql = "UPDATE `setting` SET \n"
                + "`setting_name`=?,\n"
                + "`status`=?,\n"
                + "`display_order`=?,\n"
                + "`note`=?,\n"
                + "`update_at`=?,\n"
                + "`update_by`=? \n"
                + "WHERE setting_id=? and setting_group=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, s.getSettingName());
            statement.setBoolean(2, s.isStatus());
            statement.setInt(3, s.getDisplayOrder());
            statement.setString(4, s.getNote());
            statement.setTimestamp(5, new Timestamp(s.getUpdateAt().getTime()));
            statement.setInt(6, s.getUpdateBy());
            statement.setInt(7, s.getSettingId());
            statement.setInt(8, s.getSettingGroup());
            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public void addSetting(Setting s) {
        String sql1 = "SELECT display_order \n"
                + "FROM setting\n"
                + "WHERE setting_group= ?\n"
                + "ORDER BY display_order  \n"
                + "DESC LIMIT 1";
        try {
            PreparedStatement st = connection.prepareStatement(sql1);
            st.setInt(1, s.getSettingGroup());
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                int display = rs.getInt("display_order") + 1;

                String sql = "INSERT INTO `setting`\n"
                        + "(`setting_group`, `setting_name`, `status`, `display_order`, `note`, `create_at`, `create_by`, `update_at`, `update_by`) \n"
                        + "VALUES (?,?,?,?,?,?,?,?,?)";
                statement = connection.prepareStatement(sql);
                statement.setInt(1, s.getSettingGroup());
                statement.setString(2, s.getSettingName());
                statement.setBoolean(3, s.isStatus());
                statement.setInt(4, display);
                statement.setString(5, s.getNote());
                statement.setTimestamp(6, new Timestamp(s.getCreateAt().getTime()));
                statement.setInt(7, s.getCreateBy());
                statement.setTimestamp(8, new Timestamp(s.getUpdateAt().getTime()));
                statement.setInt(9, s.getUpdateBy());
                statement.executeUpdate();
            }
        } catch (SQLException e) {

        }

    }

    public Setting getDomainBySetting(String settingName, boolean status) {
        String query = "SELECT * FROM setting WHERE setting_name = ? AND status = ?";
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, settingName);
            statement.setBoolean(2, status);
            try ( ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Setting setting = new Setting();
                    setting.setSettingId(resultSet.getInt(1));
                    setting.setSettingGroup(resultSet.getInt(2));
                    setting.setSettingName(resultSet.getString(3));
                    setting.setStatus(resultSet.getBoolean(4));
                    setting.setDisplayOrder(resultSet.getInt(5));
                    setting.setNote(resultSet.getString(6));
                    setting.setCreateAt(resultSet.getDate(7));
                    setting.setCreateBy(resultSet.getInt(8));
                    setting.setUpdateAt(resultSet.getDate(9));
                    setting.setUpdateBy(resultSet.getInt(10));

                    return setting;
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {

        }
        return null;
    }
    
}
