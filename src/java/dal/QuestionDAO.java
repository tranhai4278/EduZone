package dal;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;
import model.Question;
import model.QuestionChoise;
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

    public void addQuestion(int userId, String question, int lessonId, int chapterId, int subjectId, int createBy, int updateBy) {
        String sql;
        sql = "INSERT INTO question (question, lesson_id, chapter_id, subject_id, create_at, create_by, update_at, update_by)\n"
                + "VALUES ('" + question + "', " + lessonId + ", " + chapterId + ", " + subjectId + ", NOW(), " + userId + ", NOW(), " + userId + ");";

        try {
            statement = connection.prepareStatement(sql);
            statement.execute();
        } catch (Exception e) {
            Logger.getLogger(e.toString());
        }
    }

    public void addAnswer(String choice, int questionId, int trueAnswer) {
        String sql = "INSERT INTO question_choice (choice, question_id, true_answer)\n"
                + "VALUES\n"
                + "('" + choice + "', " + questionId + ", " + trueAnswer + ")";

        try {
            statement = connection.prepareStatement(sql);
            statement.execute();
        } catch (Exception e) {
            Logger.getLogger(e.toString());
        }
    }

    public int getQuestionIdByQuestion(String questionString) {
        String sql = "SELECT question_id FROM `question` WHERE question = '" + questionString + "'";
        int questionId = 0;
        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();

            while (result.next()) {
                questionId = result.getInt(1);
            }
            return questionId;
        } catch (Exception e) {
            return 0;
        }
    }

    public void addQuestionDimension(int questionId, int dimensionId) {
        String sql = "INSERT INTO question_dimension (question_id, dimension_id)\n"
                + "VALUES (" + questionId + ", " + dimensionId + ")";

        try {
            statement = connection.prepareStatement(sql);
            statement.execute();
        } catch (Exception e) {
            Logger.getLogger(e.toString());
        }
    }

    public ArrayList getAllQuestionQuiz() {
        ArrayList<Question> list = new ArrayList<>();
        String sql = "SELECT question, lesson_id, chapter_id, subject_id, create_at FROM `question`";
        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();
            while (result.next()) {
                String question = result.getString(1);
                int lessonId = result.getInt(2);
                int chapterId = result.getInt(3);
                int subjectId = result.getInt(4);
                Date createAt = result.getDate(5);

                Question question1 = new Question(question, lessonId, chapterId, subjectId, createAt);
                list.add(question1);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Question getQuestionById(int questionId) {
        Question q = new Question();
        String sql = "SELECT * FROM `question` WHERE question_id = " + questionId + "";

        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();
            while (result.next()) {
                String question = result.getString(2);
                int lessonId = result.getInt(3);
                int chapterId = result.getInt(4);
                int subjectId = result.getInt(5);
                Date createAt = result.getDate(6);
                int createBy = result.getInt(7);
                Date updateAt = result.getDate(8);
                int updateBy = result.getInt(9);

                q = new Question(questionId, question, lessonId, chapterId, subjectId, createAt, createBy, updateAt, updateBy);
            }
            return q;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<QuestionChoise> getAllAnswerByQuestionId(int questionId) {
        ArrayList<QuestionChoise> list = new ArrayList<>();
        String sql = "SELECT * FROM `question_choice` WHERE question_id = " + questionId + "";

        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();

            while (result.next()) {
                int choice_id = result.getInt(1);
                String choice = result.getString(2);
                boolean trueAnswer = result.getInt(4) != 0;
                QuestionChoise answer = new QuestionChoise(choice_id, choice, questionId, trueAnswer);
                list.add(answer);
            }

            return list;
        } catch (Exception e) {
            return null;
        }
    }

    public void updateQuestionWithId(int questionId, String question, int lessonId, int chapterId, int subjectId, int userId) {
        String sql = "UPDATE question SET\n"
                + "    question = '" + question + "',\n"
                + "    lesson_id = " + lessonId + ",\n"
                + "    chapter_id = " + chapterId + ",\n"
                + "    subject_id = " + subjectId + ",\n"
                + "    create_at = NOW(),\n"
                + "    create_by = " + userId + ",\n"
                + "    update_at = NOW(),\n"
                + "    update_by = " + userId + "\n"
                + "WHERE\n"
                + "    question_id = " + questionId + ";";

        try {
            statement = connection.prepareStatement(sql);
            statement.execute();
        } catch (Exception e) {
            Logger.getLogger(e.toString());
        }
    }

    public void deleteAnswerWithQuestionId(int questionId) {
        String sql = "DELETE FROM question_choice\n"
                + "WHERE question_id = " + questionId + ";";

        try {
            statement = connection.prepareStatement(sql);
            statement.execute();
        } catch (Exception e) {
            Logger.getLogger(e.toString());
        }
    }
    
        public void deleteQuestionById(int questionId) {
        String sql = "DELETE FROM question WHERE question_id = " + questionId + "";

        try {
            statement = connection.prepareStatement(sql);
            statement.execute();
        } catch (Exception e) {
            Logger.getLogger(e.toString());
        }
    }
}
