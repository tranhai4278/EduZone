package dal;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;
import model.Question;
import model.Subject;
import model.SubjectSetting;

public class QuestionDAO extends MySqlConnection {

    public ArrayList<Question> getAllQuestion() {
        ArrayList<Question> list = new ArrayList<>();
        String sql = "SELECT * FROM `question`";

        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();

            while (result.next()) {
                Question question = new Question(
                        result.getInt(1),
                        result.getString(2),
                        result.getInt(3),
                        result.getInt(4),
                        result.getInt(5),
                        result.getDate(6),
                        result.getInt(7),
                        result.getDate(8),
                        result.getInt(9));
                list.add(question);
            }

            return list;
        } catch (Exception e) {
            Logger.getLogger(e.toString());
            return null;
        }
    }

    public ArrayList<Question> getAllQuestionInformation() {
        QuestionDAO questionDao = new QuestionDAO();
        SubjectDAO subjectDao = new SubjectDAO();
        ArrayList<Question> list = new ArrayList<>();
        String sql = "SELECT * FROM `question`";

        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();

            while (result.next()) {
                int questionId = result.getInt(1);
                String questionString = result.getString(2);
                
                ArrayList<SubjectSetting> subjectSettingList = new ArrayList<>();
                subjectSettingList = questionDao.getSubjectSettingWithQuestionId(questionId);
                
                String dimension = "";
                for (SubjectSetting subjectSetting : subjectSettingList) {
                    dimension += subjectSetting.getSettingType() + "/" + subjectSetting.getSettingName() + "<br>";
                }
                
                int questionSubjectId = result.getInt(5);
                Subject subject = subjectDao.getSubjectWithId(questionSubjectId);
                String subjectCode = subject.getSubjectCode();
                
                Date createAt = result.getDate(6);
                Question question = new Question(questionId, questionString, dimension, subjectCode, createAt);
                list.add(question);
            }

            return list;
        } catch (Exception e) {
            Logger.getLogger(e.toString());
            return null;
        }
    }

    public ArrayList<SubjectSetting> getSubjectSettingWithQuestionId(int questionId) {
        ArrayList<SubjectSetting> subjectSettingList = new ArrayList<>();
        String sql = "SELECT ss.*\n"
                + "FROM question AS q\n"
                + "JOIN question_dimension AS qd ON q.question_id = qd.question_id\n"
                + "JOIN subject_setting AS ss ON qd.dimension_id = ss.setting_id\n"
                + "WHERE q.question_id = '" + questionId + "';";

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
                Date createAt = result.getDate(8);
                int createBy = result.getInt(9);
                Date updateAt = result.getDate(10);
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
}
