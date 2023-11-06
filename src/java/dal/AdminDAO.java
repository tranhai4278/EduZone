package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.Setting;
import model.Subject;
import model.User;

public class AdminDAO extends MySqlConnection {

    public ArrayList<Setting> getSemesters() {
        ArrayList<Setting> semesters = new ArrayList<>();
        String sql = "SELECT * FROM setting WHERE setting_group = 3";

        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();

            while (result.next()) {
                Setting semester = new Setting(
                        result.getInt(1),
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

                semesters.add(semester);
            }
        } catch (SQLException e) {
            // Handle any potential exceptions here
        }

        return semesters;
    }

    public List<Subject> getAllSubject() {
        List<Subject> list = new ArrayList<>();
        String sql = " SELECT s.*,u.user_id,u.full_name,u.role_id FROM subject s, user u WHERE u.user_id = s.manager_id";
        try {
            statement = connection.prepareStatement(sql);
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
                s.setU(new User(result.getInt(11), result.getString(12), result.getInt(13)));
                list.add(s);

            }
        } catch (SQLException e) {

        }
        return list;
    }

    public List<Subject> searchBySubjectName(String name) {
        List<Subject> list = new ArrayList<>();
        String sql = "SELECT * FROM `subject` WHERE subject_name like N'%" + name + "%' or subject_code like N'%" + name + "%'  ";
        try {
            statement = connection.prepareStatement(sql);
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

    public Subject getSubjectbyId(int id) {
        Subject p = null;
        String sql = "SELECT s.*,u.user_id,u.full_name,u.role_id FROM subject s, user u WHERE subject_id = ? AND s.manager_id=u.user_id";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            result = statement.executeQuery();
            while (result.next()) {
                p = new Subject(result.getInt(1),
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
                p.setU(new User(result.getInt(11), result.getString(12), result.getInt(13)));
            }
        } catch (SQLException e) {

        }
        return p;
    }

    public List<User> getAllSubManager() {
        List<User> list = new ArrayList<>();
        String sql = " SELECT u.user_id,u.full_name,u.role_id\n"
                + "FROM user u, setting s\n"
                + "WHERE u.role_id=s.setting_id and s.setting_group=1 AND s.setting_id=2 and u.status=1";
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
            statement.setBoolean(5, s.isStatus());
            statement.setTimestamp(6, new Timestamp(s.getUpdateAt().getTime()));
            statement.setInt(7, s.getUpdateBy());
            statement.setInt(8, s.getSubjectId());
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

    public List<Setting> getAllSettingSemester() {
        List<Setting> list = new ArrayList<>();
        String sql = " SELECT * FROM `setting` WHERE setting_group=3 and status = 1 ";
        try {
            statement = connection.prepareStatement(sql);
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

    public Setting checkSettingName(String name, int sid) {
        Setting p = null;
        String sql = "SELECT * FROM setting WHERE setting_name = N? and setting_id != ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
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

    public Setting checkSettingNameinGroup(String name, int gid) {
        Setting p = null;
        String sql = "SELECT * FROM setting WHERE setting_name = N? AND setting_group = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, gid);
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

    public Subject checkSubjectCode(String name, int sid) {
        Subject p = null;
        String sql = "SELECT * FROM `subject` WHERE subject_code = N? and subject_id!=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setInt(2, sid);

            result = statement.executeQuery();
            while (result.next()) {
                p = new Subject(result.getInt(1),
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
            }
        } catch (SQLException e) {

        }
        return p;
    }

    public List<Setting> getAllSetting() {
        List<Setting> list = new ArrayList<>();
        String sql = " SELECT * FROM `setting` ";
        try {
            statement = connection.prepareStatement(sql);
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

     public List<Setting> searchAndFilterSettings(String searchName, Integer status, Integer group, String sortBy, Integer page) {
        List<Setting> settings = new ArrayList<>();

        try {
            String query = "SELECT * FROM `setting` WHERE 1=1";
            if (searchName != null && !searchName.isEmpty()) {
                query += " AND setting_name LIKE ?";
            }

            if (status > -1) {
                query += " AND status = ?";
            }

            if (group > 0) {
                query += " AND setting_group = ?";
            }

            if (sortBy != null && !sortBy.isEmpty()) {
                query += " ORDER BY " + sortBy;
            }

            query += " LIMIT 10 OFFSET ?"; // Đã thêm OFFSET

            statement = connection.prepareStatement(query);

            // Set parameters based on the filters and pagination
            int parameterIndex = 1;
            if (searchName != null && !searchName.isEmpty()) {
                statement.setString(parameterIndex++, "%" + searchName + "%");
            }
            if (status > -1) {
                statement.setInt(parameterIndex++, status);
            }
            if (group > 0) {
                statement.setInt(parameterIndex++, group);
            }

            statement.setInt(parameterIndex++, (page - 1) * 10); // Set giá trị cho OFFSET

            // Execute the query
            result = statement.executeQuery();

            // Process the result set and populate the list of settings
            while (result.next()) {
                Setting setting = new Setting();
                // Populate the Setting object with data from the result set
                setting.setSettingId(result.getInt(1));
                setting.setSettingGroup(result.getInt(2));
                setting.setSettingName(result.getString(3));
                setting.setStatus(result.getBoolean(4));
                setting.setDisplayOrder(result.getInt(5));
                setting.setNote(result.getString(6));
                setting.setCreateAt(result.getDate(7));
                setting.setCreateBy(result.getInt(8));
                setting.setUpdateAt(result.getDate(9));
                setting.setUpdateBy(result.getInt(10));
                // Add the Setting object to the list
                settings.add(setting);
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

        return settings;
    }

    public List<Subject> searchAndFilterSubjects(String searchName, Integer managerId, Integer status, String sortBy, Integer page) {
        List<Subject> subjects = new ArrayList<>();

        try {
            // Bắt đầu tạo câu truy vấn SQL
            String query = "SELECT s.*, u.user_id,u.full_name,u.role_id FROM `subject` s, user u WHERE 1=1 and u.user_id=s.manager_id";

            if (searchName != null && !searchName.isEmpty()) {
                query += " AND s.subject_name LIKE ? ";
            }

            if (managerId > -1) {
                query += " AND s.manager_id = ?";
            }
            if (status > -1) {
                query += " AND s.status = ?";
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
            if (searchName != null && !searchName.isEmpty()) {
                statement.setString(parameterIndex++, "%" + searchName + "%");
            }

            if (managerId > -1) {
                statement.setInt(parameterIndex++, managerId);
            }
            if (status > -1) {
                statement.setInt(parameterIndex++, status);
            }

            statement.setInt(parameterIndex++, (page - 1) * 10);

            // Thực hiện truy vấn
            result = statement.executeQuery();

            // Xử lý kết quả và thêm vào danh sách subjects
            while (result.next()) {
                Subject subject = new Subject();
                // Thêm dữ liệu từ kết quả vào đối tượng Subject
                subject.setSubjectId(result.getInt(1));
                subject.setManagerId(result.getInt(2));
                subject.setSubjectName(result.getString(3));
                subject.setSubjectCode(result.getString(4));
                subject.setDescription(result.getString(5));
                subject.setStatus(result.getBoolean(6));
                subject.setCreateAt(result.getDate(7));
                subject.setCreateBy(result.getInt(8));
                subject.setUpdateAt(result.getDate(9));
                subject.setUpdateBy(result.getInt(10));
                subject.setU(new User(result.getInt(11), result.getString(12), result.getInt(13)));
                subjects.add(subject);
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

        return subjects;
    }

    public int totalPageSetting(String searchName, Integer status, Integer group, String sortBy) {
        int totalPages = 0;
        try {
            String query = "SELECT COUNT(*) FROM `setting` WHERE 1=1";
            if (searchName != null && !searchName.isEmpty()) {
                query += " AND setting_name LIKE ?";
            }

            if (status >= 0) {
                query += " AND status = ?";
            }

            if (group > 0) {
                query += " AND setting_group = ?";
            }

            if (sortBy != null && !sortBy.isEmpty()) {
                query += " ORDER BY " + sortBy;
            }

            statement = connection.prepareStatement(query);

            // Set parameters based on the filters and pagination
            int parameterIndex = 1;
            if (searchName != null && !searchName.isEmpty()) {
                statement.setString(parameterIndex++, "%" + searchName + "%");
            }
            if (status >= 0) {
                statement.setInt(parameterIndex++, status);
            }
            if (group > 0) {
                statement.setInt(parameterIndex++, group);
            }

            // Execute the query
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

    public int totalPageSetting() {
        int itemsPerPage = 10;
        int totalPages = 0;
        try {
            String countQuery = "SELECT COUNT(*) FROM setting";
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

    public int totalPageSubject() {
        int itemsPerPage = 10;
        int totalPages = 0;
        try {
            String countQuery = "SELECT COUNT(*) FROM subject";
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

    public int totalPageSubject(String searchName, Integer managerId, Integer status, String sortBy, Integer page) {
        int totalPages = 0;

        try {
            String query = "SELECT s.*, u.user_id,u.full_name,u.role_id FROM `subject`s, user u WHERE 1=1 and u.user_id=s.manager_id";

            if (searchName != null && !searchName.isEmpty()) {
                query += " AND s.subject_name LIKE ?";
            }

            if (managerId > -1) {
                query += " AND s.manager_id = ?";
            }
            if (status > -1) {
                query += " AND s.status = ?";
            }

            if (sortBy != null && !sortBy.isEmpty()) {
                query += " ORDER BY " + sortBy;
            }

            // Thêm phần phân trang
            System.out.println(query);

            // Chuẩn bị câu truy vấn
            statement = connection.prepareStatement(query);

            // Đặt các tham số dựa trên các điều kiện và phân trang
            int parameterIndex = 1;
            if (searchName != null && !searchName.isEmpty()) {
                statement.setString(parameterIndex++, "%" + searchName + "%");
            }

            if (managerId > 0) {
                statement.setInt(parameterIndex++, managerId);
            }
            if (status > -1) {
                statement.setInt(parameterIndex++, status);
            }

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

    public static void main(String[] args) {
        AdminDAO dao = new AdminDAO();
        System.out.println(dao.searchAndFilterSubjects("a", -1, -1, null, 1));
    }

}
