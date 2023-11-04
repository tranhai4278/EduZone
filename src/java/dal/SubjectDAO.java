package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import model.Subject;
import model.SubjectSetting;
import model.User;

public class SubjectDAO extends MySqlConnection {
    public ArrayList<Subject> getSubjectsByManagerId(int managerId) {
        ArrayList<Subject> subjects = new ArrayList<>();
        String sql = "SELECT * FROM subject WHERE manager_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, managerId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int subjectId = resultSet.getInt(1);
                String subjectName = resultSet.getString(3);
                String subjectCode = resultSet.getString(4);
                String description = resultSet.getString(5);
                boolean status = resultSet.getBoolean(6);
                Date createAt = resultSet.getDate(7);
                int createBy = resultSet.getInt(8);
                Date updateAt = resultSet.getDate(9);
                int updateBy = resultSet.getInt(10);

                Subject subject = new Subject(
                        subjectId,
                        managerId,
                        subjectName,
                        subjectCode,
                        description,
                        status,
                        createAt,
                        createBy,
                        updateAt,
                        updateBy
                );

                subjects.add(subject);
            }

            return subjects;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public ArrayList getAllSubjects() {
        ArrayList<Subject> list = new ArrayList<>();
        String sql = "select * from subject";

        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();

            while (result.next()) {
                int subject_id = result.getInt(1);
                int manager_id = result.getInt(2);
                String subject_name = result.getString(3);
                String subject_code = result.getString(4);
                String description = result.getString(5);
                boolean status = result.getBoolean(6);
                Date create_at = result.getDate(7);
                int create_by = result.getInt(8);
                Date update_at = result.getDate(9);
                int update_by = result.getInt(10);
                Subject subject = new Subject(
                        subject_id,
                        manager_id,
                        subject_name,
                        subject_code,
                        description,
                        status,
                        create_at,
                        create_by,
                        update_at,
                        update_by);
                list.add(subject);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void addSubject(int mID, String name, String code, String des, String image) {
        try {
            String strSelect = "INSERT INTO subject (manager_id, subject_name, subject_code, description, img_url, \n"
                    + "status, create_at, create_by, update_at, update_by)\n"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            Connection cnn = (new MySqlConnection()).connection;
            PreparedStatement pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, mID);
            pstm.setString(2, name);
            pstm.setString(3, code);
            pstm.setString(4, des);
            pstm.setString(5, image);
            pstm.setBoolean(6, true );
            java.util.Date d = new java.util.Date();
            java.sql.Date createdAt = new java.sql.Date(d.getTime());
            java.sql.Date updatedAt = new java.sql.Date(d.getTime());
            pstm.setDate(7, createdAt);
            pstm.setInt(8, 1);
            pstm.setDate(9, updatedAt);
            pstm.setInt(10, 1);

            pstm.executeUpdate();

        } catch (Exception e) {
            System.out.println("addAccount: " + e.getMessage());
        }
    }


    public ArrayList getAllSubjectsWithUser() {
        UserDAO userDao = new UserDAO();
        ArrayList<Subject> list = new ArrayList<>();
        String sql = "select * from subject";

        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();

            while (result.next()) {
                int subject_id = result.getInt(1);
                int manager_id = result.getInt(2);
                String subject_name = result.getString(3);
                String subject_code = result.getString(4);
                String description = result.getString(5);
                boolean status = result.getBoolean(6);
                Date create_at = result.getDate(7);
                int create_by = result.getInt(8);
                Date update_at = result.getDate(9);
                int update_by = result.getInt(10);
                User user = userDao.getUserById(manager_id);
                String managerName = user.getFullName();
                Subject subject = new Subject(
                        subject_id,
                        manager_id,
                        managerName,
                        subject_name,
                        subject_code,
                        description,
                        status,
                        create_at,
                        create_by,
                        update_at,
                        update_by);
                list.add(subject);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList getAllSubjectNames() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "SELECT subject_name FROM `subject`";

        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();

            while (result.next()) {
                String subjectName = result.getString(1);
                list.add(subjectName);
            }
            return list;
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }

    public ArrayList getAllSubjectCodes() {
        ArrayList<String> list = new ArrayList<>();
        String sql = "SELECT subject_code FROM `subject`";

        try {
                statement = connection.prepareStatement(sql);
            result = statement.executeQuery();

            while (result.next()) {
                String SubjectCode = result.getString(1);
                list.add(SubjectCode);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList getSubjectListByNameAndCode(String subjectString) {
        ArrayList<Subject> list = new ArrayList<>();
        String sql = "SELECT *\n"
                + "FROM subject\n"
                + "WHERE subject_name LIKE '%" + subjectString + "%' OR subject_code LIKE '%" + subjectString + "%';";

        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();

            while (result.next()) {
                int subject_id = result.getInt(1);
                int manager_id = result.getInt(2);
                String subject_name = result.getString(3);
                String subject_code = result.getString(4);
                String description = result.getString(5);
                boolean status = result.getBoolean(6);
                Date create_at = result.getDate(7);
                int create_by = result.getInt(8);
                Date update_at = result.getDate(9);
                int update_by = result.getInt(10);
                Subject subject = new Subject(
                        subject_id,
                        manager_id,
                        subject_name,
                        subject_code,
                        description,
                        status,
                        create_at,
                        create_by,
                        update_at,
                        update_by);
                list.add(subject);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList getSubjectListByNameAndCodeWithUser(String subjectString) {
        UserDAO userDao = new UserDAO();
        ArrayList<Subject> list = new ArrayList<>();
        String sql = "SELECT *\n"
                + "FROM subject\n"
                + "WHERE subject_name LIKE '%" + subjectString + "%' OR subject_code LIKE '%" + subjectString + "%';";

        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();

            while (result.next()) {
                int subject_id = result.getInt(1);
                int manager_id = result.getInt(2);
                String subject_name = result.getString(3);
                String subject_code = result.getString(4);
                String description = result.getString(5);
                boolean status = result.getBoolean(6);
                Date create_at = result.getDate(7);
                int create_by = result.getInt(8);
                Date update_at = result.getDate(9);
                int update_by = result.getInt(10);
                User user = userDao.getUserById(manager_id);
                String managerName = user.getFullName();
                Subject subject = new Subject(
                        subject_id,
                        manager_id,
                        managerName,
                        subject_name,
                        subject_code,
                        description,
                        status,
                        create_at,
                        create_by,
                        update_at,
                        update_by);
                list.add(subject);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
    public Subject getSubjectWithId(int subject_id) {
        Subject subject = new Subject();
        String sql = "SELECT *\n"
                + "FROM subject\n"
                + "WHERE subject_id = " + subject_id + ";";

        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();

            while (result.next()) {
                int manager_id = result.getInt(2);
                String subject_name = result.getString(3);
                String subject_code = result.getString(4);
                String description = result.getString(5);
                boolean status = result.getBoolean(6);
                Date create_at = result.getDate(7);
                int create_by = result.getInt(8);
                Date update_at = result.getDate(9);
                int update_by = result.getInt(10);
                subject = new Subject(
                        subject_id,
                        manager_id,
                        subject_name,
                        subject_code,
                        description,
                        status,
                        create_at,
                        create_by,
                        update_at,
                        update_by);
            }

            return subject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Subject getSubjectByCode(String code) {
        String query ="SELECT * FROM `subject` WHERE subject_code = ?";
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, code);
            try ( ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Subject s = new Subject();
                    s.setSubjectId(resultSet.getInt(1));
                    s.setManagerId(resultSet.getInt(2));
                    s.setSubjectName(resultSet.getString(3));
                    s.setSubjectCode(resultSet.getString(4));
                    s.setDescription(resultSet.getString(5));
                    s.setStatus(resultSet.getBoolean(6));
                    s.setCreateAt(resultSet.getDate(7));
                    s.setCreateBy(resultSet.getInt(8));
                    s.setUpdateAt(resultSet.getDate(9));
                    s.setUpdateBy(resultSet.getInt(10));
                    return s;
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {

        }
        return null;
    }
    

    public Subject getSubjectAndManagerWithId(int subject_id) {
        UserDAO userDao = new UserDAO();
        Subject subject = new Subject();
        String sql = "SELECT *\n"
                + "FROM subject\n"
                + "WHERE subject_id = " + subject_id + ";";

        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();

            while (result.next()) {
                int manager_id = result.getInt(2);
                String subject_name = result.getString(3);
                String subject_code = result.getString(4);
                String description = result.getString(5);
                boolean status = result.getBoolean(6);
                Date create_at = result.getDate(7);
                int create_by = result.getInt(8);
                Date update_at = result.getDate(9);
                int update_by = result.getInt(10);
                User user = userDao.getUserById(manager_id);
                subject = new Subject(
                        subject_id,
                        manager_id,
                        subject_name,
                        subject_code,
                        description,
                        status,
                        create_at,
                        create_by,
                        update_at,
                        update_by,
                        user);
            }

            return subject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<SubjectSetting> getAllSubjectSetting() {
        ArrayList<SubjectSetting> subjectSettingList = new ArrayList<>();
        String sql = "SELECT * FROM `subject_setting` WHERE setting_type != 'Chapter'";

        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();
            
            while (result.next()) {
                int settingId = result.getInt(1);
                int subjectId = result.getInt(2);
                String settingType = result.getString(3);
                String settingName = result.getString(4);
                String description = result.getString(5);
                int displayOrder = result.getInt(6);
                int status = result.getInt(7);
                boolean boolStatus = (status == 1);
                java.util.Date createAt = result.getDate(8);
                int createBy = result.getInt(9);
                java.util.Date updateAt = result.getDate(10);
                int updateBy = result.getInt(11);
                SubjectSetting subjectSetting = new SubjectSetting(settingId, subjectId, settingType, settingName, description, displayOrder, boolStatus, createAt, createBy, updateAt, updateBy);
                subjectSettingList.add(subjectSetting);
            }
            
            return subjectSettingList;
        } catch (Exception e) {
            Logger.getLogger(e.toString());
            return null;
        }
    }
    
   public ArrayList<Subject> getSubjectsByTrainer(int id) {
        ArrayList<Subject> subjects = new ArrayList<>();
        String sql = "SELECT s.subject_id, s.manager_id, s.subject_name, s.subject_code, s.description, s.status, s.create_at, s.create_by, s.update_at, s.update_by "
                + "FROM `class`c JOIN subject s ON c.subject_id = s.subject_id  WHERE c.trainer_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int subjectId = resultSet.getInt(1);
                int managerId = resultSet.getInt(2);
                String subjectName = resultSet.getString(3);
                String subjectCode = resultSet.getString(4);
                String description = resultSet.getString(5);
                boolean status = resultSet.getBoolean(6);
                Date createAt = resultSet.getDate(7);
                int createBy = resultSet.getInt(8);
                Date updateAt = resultSet.getDate(9);
                int updateBy = resultSet.getInt(10);

                Subject subject = new Subject(
                        subjectId,
                        managerId,
                        subjectName,
                        subjectCode,
                        description,
                        status,
                        createAt,
                        createBy,
                        updateAt,
                        updateBy
                );

                subjects.add(subject);
            }

            return subjects;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
   
   public ArrayList<Subject> getSubjectsByTrainee(int id) {
        ArrayList<Subject> subjects = new ArrayList<>();
        String sql = "SELECT s.subject_id, s.manager_id, s.subject_name, s.subject_code, s.description, s.status, s.create_at, s.create_by, s.update_at, s.update_by "
                + "FROM `class`c JOIN subject s ON c.subject_id = s.subject_id JOIN class_student cs ON c.class_id = cs.class_id WHERE cs.trainee_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int subjectId = resultSet.getInt(1);
                int managerId = resultSet.getInt(2);
                String subjectName = resultSet.getString(3);
                String subjectCode = resultSet.getString(4);
                String description = resultSet.getString(5);
                boolean status = resultSet.getBoolean(6);
                Date createAt = resultSet.getDate(7);
                int createBy = resultSet.getInt(8);
                Date updateAt = resultSet.getDate(9);
                int updateBy = resultSet.getInt(10);

                Subject subject = new Subject(
                        subjectId,
                        managerId,
                        subjectName,
                        subjectCode,
                        description,
                        status,
                        createAt,
                        createBy,
                        updateAt,
                        updateBy
                );

                subjects.add(subject);
            }

            return subjects;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
   
    public static void main(String[] args) {
        SubjectDAO dao = new SubjectDAO();
        List<Subject> listS = dao.getSubjectsByTrainer(5);
        for (Subject s : listS) {
            System.out.println(s.getSubjectCode());
        }
    }

}
