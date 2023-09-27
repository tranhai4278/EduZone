package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import model.Subject;
import model.User;

public class SubjectDAO extends MySqlConnection {

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
                String img_url = result.getString(6);
                boolean status = result.getBoolean(7);
                Date create_at = result.getDate(8);
                int create_by = result.getInt(9);
                Date update_at = result.getDate(10);
                int update_by = result.getInt(11);
                Subject subject = new Subject(
                        subject_id,
                        manager_id,
                        subject_name,
                        subject_code,
                        description,
                        img_url,
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
    
    public void addSubject(int mID, String name, String code, String des, String image, boolean status,  int createBy, int updateBy) {
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
            pstm.setBoolean(6, status );
            java.util.Date d = new java.util.Date();
            java.sql.Date createdAt = new java.sql.Date(d.getTime());
            java.sql.Date updatedAt = new java.sql.Date(d.getTime());
            pstm.setDate(7, createdAt);
            pstm.setInt(8, createBy);
            pstm.setDate(9, updatedAt);
            pstm.setInt(10, updateBy);
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
                String img_url = result.getString(6);
                boolean status = result.getBoolean(7);
                Date create_at = result.getDate(8);
                int create_by = result.getInt(9);
                Date update_at = result.getDate(10);
                int update_by = result.getInt(11);
                User user = userDao.getUserById(manager_id);
                String managerName = user.getFullName();
                Subject subject = new Subject(
                        subject_id,
                        manager_id,
                        managerName,
                        subject_name,
                        subject_code,
                        description,
                        img_url,
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
                String img_url = result.getString(6);
                boolean status = result.getBoolean(7);
                Date create_at = result.getDate(8);
                int create_by = result.getInt(9);
                Date update_at = result.getDate(10);
                int update_by = result.getInt(11);
                Subject subject = new Subject(
                        subject_id,
                        manager_id,
                        subject_name,
                        subject_code,
                        description,
                        img_url,
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
                String img_url = result.getString(6);
                boolean status = result.getBoolean(7);
                Date create_at = result.getDate(8);
                int create_by = result.getInt(9);
                Date update_at = result.getDate(10);
                int update_by = result.getInt(11);
                User user = userDao.getUserById(manager_id);
                String managerName = user.getFullName();
                Subject subject = new Subject(
                        subject_id,
                        manager_id,
                        managerName,
                        subject_name,
                        subject_code,
                        description,
                        img_url,
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
                String img_url = result.getString(6);
                boolean status = result.getBoolean(7);
                Date create_at = result.getDate(8);
                int create_by = result.getInt(9);
                Date update_at = result.getDate(10);
                int update_by = result.getInt(11);
                subject = new Subject(
                        subject_id,
                        manager_id,
                        subject_name,
                        subject_code,
                        description,
                        img_url,
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
                String img_url = result.getString(6);
                boolean status = result.getBoolean(7);
                Date create_at = result.getDate(8);
                int create_by = result.getInt(9);
                Date update_at = result.getDate(10);
                int update_by = result.getInt(11);
                User user = userDao.getUserById(manager_id);
                subject = new Subject(
                        subject_id,
                        manager_id,
                        subject_name,
                        subject_code,
                        description,
                        img_url,
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

}
