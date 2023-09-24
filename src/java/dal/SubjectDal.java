package dal;

import java.sql.Date;
import java.util.ArrayList;
import model.Subject;

public class SubjectDal extends MySqlConnection {

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
}
