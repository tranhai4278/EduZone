/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import model.Discussion;
import model.Subject;
import model.SubjectSetting;
import model.User;

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

    public List<Discussion> filterDiscussion(int subjectId, int userId, String title, int status, String sortBy, int page) {
        List<Discussion> DiscussionList = new ArrayList<>();

        try {
            // Bắt đầu tạo câu truy vấn SQL
            String query = "SELECT \n"
                    + "    d.discussion_id,\n"
                    + "    d.subject_id,\n"
                    + "    c.class_code AS class_code,\n"
                    + "    d.title,\n"
                    + "    d.description,\n"
                    + "    u.full_name AS full_name,\n"
                    + "    d.start_time,\n"
                    + "    d.end_time,\n"
                    + "    d.status,\n"
                    + "    d.created_at,\n"
                    + "    d.create_by,\n"
                    + "    d.update_at,\n"
                    + "    d.update_by\n"
                    + "FROM discussion AS d\n"
                    + "INNER JOIN class AS c ON d.class_id = c.class_id\n"
                    + "INNER JOIN class_student AS cs ON c.class_id = cs.class_id\n"
                    + "INNER JOIN user AS u ON d.user_id = u.user_id\n"
                    + "WHERE d.subject_id = " + subjectId + "\n"
                    + "  AND cs.trainee_id = " + userId + "";

            if (title != null && !title.isEmpty()) {
                query += " AND d.title LIKE ? ";
            }

            if (status > -1) {
                query += " AND d.status = ?";
            }

            if (sortBy != null && !sortBy.isEmpty()) {
                query += " ORDER BY " + sortBy;
            }

            // Thêm phần phân trang
            query += " LIMIT 10 OFFSET ?";
            System.out.println(query);

            // Chuẩn bị câu truy vấn
            statement = connection.prepareStatement(query);

            // Đặt các tham số dựa trên các điều kiện và phân trang
            int parameterIndex = 1;
            if (title != null && !title.isEmpty()) {
                statement.setString(parameterIndex++, "%" + title + "%");
            }

            if (status > -1) {
                statement.setInt(parameterIndex++, status);
            }

            statement.setInt(parameterIndex++, (page - 1) * 10);

            // Thực hiện truy vấn
            result = statement.executeQuery();

            // Xử lý kết quả và thêm vào danh sách subjects
            while (result.next()) {
                Discussion discussion = new Discussion();
                discussion.setDiscussionId(result.getInt(1));
                discussion.setSubjectId(result.getInt(2));
                discussion.setClassCode(result.getString(3));
                discussion.setTitle(result.getString(4));
                discussion.setDescription(result.getString(5));
                discussion.setUserName(result.getString(6));

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-uuuu | HH:mm");
                Timestamp startTime = result.getTimestamp(7);
                Instant instantStartTime = startTime.toInstant();
                LocalDateTime localStartTime = instantStartTime.atZone(ZoneId.systemDefault()).toLocalDateTime();
                discussion.setFormattedStartTime(localStartTime.format(formatter));

                Timestamp endTime = result.getTimestamp(8);
                Instant instantEndTime = endTime.toInstant();
                LocalDateTime localEndTime = instantEndTime.atZone(ZoneId.systemDefault()).toLocalDateTime();
                discussion.setFormattedEndTime(localEndTime.format(formatter));

                discussion.setStatus(result.getBoolean(9));
                discussion.setCreateAt(result.getDate(10));
                discussion.setCreateBy(result.getInt(11));
                discussion.setUpdateAt(result.getDate(12));
                discussion.setUpdateBy(result.getInt(13));
                DiscussionList.add(discussion);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database resources
            try {
                if (result != null) {
                    result.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return DiscussionList;
    }

    public int totalPageDiscussion() {
        int itemsPerPage = 10;
        int totalPages = 0;
        try {
            String countQuery = "SELECT COUNT(*) FROM discussion";
            PreparedStatement countStatement = connection.prepareStatement(countQuery);

            ResultSet countResult = countStatement.executeQuery();
            countResult.next();

            int totalItems = countResult.getInt(1);
            countStatement.close();
            totalPages = (int) Math.ceil((double) totalItems / itemsPerPage);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalPages;
    }

    public int totalPageDiscussion(int subjectId, int userId, String title, int status, String sortBy, int page) {
        int totalPages = 0;

        try {
            // Bắt đầu tạo câu truy vấn SQL
            String query = "SELECT \n"
                    + "    d.discussion_id,\n"
                    + "    d.subject_id,\n"
                    + "    c.class_code AS class_code,\n"
                    + "    d.title,\n"
                    + "    d.description,\n"
                    + "    u.full_name AS user_full_name,\n"
                    + "    d.start_time,\n"
                    + "    d.end_time,\n"
                    + "    d.status,\n"
                    + "    d.created_at,\n"
                    + "    d.create_by,\n"
                    + "    d.update_at,\n"
                    + "    d.update_by\n"
                    + "FROM discussion AS d\n"
                    + "INNER JOIN class AS c ON d.class_id = c.class_id\n"
                    + "INNER JOIN class_student AS cs ON c.class_id = cs.class_id\n"
                    + "INNER JOIN user AS u ON d.user_id = u.user_id\n"
                    + "WHERE d.subject_id = " + subjectId + "\n"
                    + "  AND cs.trainee_id = " + userId + "";

            if (title != null && !title.isEmpty()) {
                query += " AND d.title LIKE ? ";
            }

            if (status > -1) {
                query += " AND d.status = ?";
            }

            if (sortBy != null && !sortBy.isEmpty()) {
                query += " ORDER BY " + sortBy;
            }

            // Thêm phần phân trang
            query += " LIMIT 10 OFFSET ?";
            System.out.println(query);

            // Chuẩn bị câu truy vấn
            statement = connection.prepareStatement(query);

            // Đặt các tham số dựa trên các điều kiện và phân trang
            int parameterIndex = 1;
            if (title != null && !title.isEmpty()) {
                statement.setString(parameterIndex++, "%" + title + "%");
            }

            if (status > -1) {
                statement.setInt(parameterIndex++, status);
            }

            statement.setInt(parameterIndex++, (page - 1) * 10);

            // Thực hiện truy vấn
            result = statement.executeQuery();

            if (result.next()) {
                int totalItems = result.getInt(1);
                totalPages = (int) Math.ceil((double) totalItems / 10);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database resources
            try {
                if (result != null) {
                    result.close();
                }
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return totalPages;
    }

    public void updateStatusDiscussion(int discussionId, boolean status) {
        String sql = "UPDATE discussion SET status = ? WHERE discussion_id = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setBoolean(1, status);
            statement.setInt(2, discussionId);
            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }
    
    public static void main(String[] args) {
        ManagerDAO managerDao = new ManagerDAO();

        List<Discussion> discussionList = managerDao.filterDiscussion(1, 2, "", -1, null, 1);
        System.out.println(discussionList);
    }
}
