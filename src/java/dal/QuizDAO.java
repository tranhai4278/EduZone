/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Question;
import model.Quiz;
import model.QuizConfig;
import model.QuizResult;
import model.Subject;
import model.SubjectSetting;

import java.time.ZoneId;

/**
 *
 * @author MinhDQ
 */
public class QuizDAO extends MySqlConnection {

    public ArrayList<Quiz> getAllQuizzes() {
        ArrayList<Quiz> quizList = new ArrayList<>();
        String sql = "SELECT q.* , s.subject_code, c.setting_name FROM quiz q JOIN subject s ON s.subject_id = q.subject_id LEFT JOIN subject_setting c ON c.setting_id = q.chapter_id";
        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();

            while (result.next()) {
                int quiz_id = result.getInt(1);
                String quiz_name = result.getString(2);
                int subject_id = result.getInt(3);
                int chapter_id = result.getInt(4);
                boolean quiz_type = result.getBoolean(5);
                int number_of_question = result.getInt(6);
                boolean status = result.getBoolean(7);
                int quiz_time = result.getInt(8);
                Date create_At = result.getDate(9);
                int create_By = result.getInt(10);
                Date update_At = result.getDate(11);
                int update_By = result.getInt(12);
                String subject_code = result.getString(13);
                String setting_name = result.getString(14);
                Subject s = new Subject(subject_code);
                SubjectSetting ss = new SubjectSetting(setting_name);
                Quiz quiz = new Quiz(quiz_id, quiz_name, subject_id, chapter_id, quiz_type, number_of_question, status, quiz_time, create_At, create_By, update_At, update_By, s, ss);
                quizList.add(quiz);
            }
            return quizList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quizList;
    }

    public ArrayList<Quiz> getQuizByPage(ArrayList<Quiz> quizList, int start, int end) {
        ArrayList<Quiz> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(quizList.get(i));
        }
        return arr;
    }

    public ArrayList<Quiz> searchQuiz(String searchContent, String subject, String chapter) {
        ArrayList<Quiz> quizList = new ArrayList<>();
        String sql = "SELECT * FROM quiz q \n"
                + "JOIN subject s ON s.subject_id = q.subject_id \n"
                + "LEFT JOIN subject_setting ss ON ss.setting_id = q.chapter_id\n"
                + "where q.quiz_name like ? or q.subject_id like ? or q.chapter_id like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + searchContent + "%");
            st.setString(2, "%" + subject + "%");
            st.setString(3, "%" + chapter + "%");
            ResultSet result = st.executeQuery();
            while (result.next()) {
                int quiz_id = result.getInt(1);
                String quiz_name = result.getString(2);
                int subject_id = result.getInt(3);
                int chapter_id = result.getInt(4);
                boolean quiz_type = result.getBoolean(5);
                int number_of_question = result.getInt(6);
                boolean status = result.getBoolean(7);
                int quiz_time = result.getInt(8);
                Date create_At = result.getDate(9);
                int create_By = result.getInt(10);
                Date update_At = result.getDate(11);
                int update_By = result.getInt(12);
                String subject_code = result.getString(13);
                String setting_name = result.getString(14);
                Subject s = new Subject(subject_code);
                SubjectSetting ss = new SubjectSetting(setting_name);
                Quiz quiz = new Quiz(quiz_id, quiz_name, subject_id, chapter_id, quiz_type, number_of_question, status, quiz_time, create_At, create_By, update_At, update_By, s, ss);
                quizList.add(quiz);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return quizList;
    }

    public Quiz getQuiz(String getBy, String value) {
        String sql = "SELECT q.quiz_id, q.quiz_name,q.subject_id, q.chapter_id, q.quiz_type,  q.number_of_question, \n"
                + "q.status, q.quiz_time, q.create_at, q.create_by, q.update_at, q.update_by \n"
                + "from quiz q \n"
                + "where " + getBy + " = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, value);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Quiz q = new Quiz();
                Subject s = new Subject();
                SubjectSetting ss = new SubjectSetting();
                q.setQuizId(rs.getInt("quiz_id"));
                q.setQuizName(rs.getString("quiz_name"));
                s.setSubjectId(rs.getInt("subject_id"));
                ss.setSettingId(rs.getInt("chapter_id"));
                q.setQuizType(rs.getBoolean("quiz_type"));
                q.setNumberQuestion(rs.getInt("number_of_question"));
                q.setStatus(rs.getBoolean("status"));
                q.setQuizTime(rs.getInt("quiz_time"));
                q.setCreateAt(rs.getDate("create_at"));
                q.setCreateBy(rs.getInt("create_by"));
                q.setUpdateAt(rs.getDate("update_at"));
                q.setUpdateBy(rs.getInt("update_by"));
                q.setS(s);
                q.setSs(ss);
                return q;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<Question> getQuestionsByQuiz(String quizId) {
        ArrayList<Question> questionList = new ArrayList<>();
        String sql = "SELECT q.question_id, q.question \n"
                + "FROM question q INNER JOIN quiz_question qq \n"
                + "ON qq.question_id = q.question_id \n"
                + "WHERE q.flag = 1 AND qq.quiz_id = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, quizId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int questionId = rs.getInt("question_id");
                String question = rs.getString("question");
                Question ques = new Question();
                ques.setQuestionId(questionId);
                ques.setQuestion(question);
                questionList.add(ques);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questionList;
    }

    public ArrayList<Question> getQuestionToAdd(Quiz quiz) {
        ArrayList<Question> questionListToAdd = new ArrayList<>();
        String sql = "SELECT *\n"
                + "FROM question q\n"
                + "WHERE question_id NOT IN (\n"
                + "SELECT question_id\n"
                + "FROM quiz_question\n"
                + " WHERE quiz_id = ? ) And q.subject_id = ? And q.chapter_id = ? And q.flag = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, quiz.getQuizId());
            ps.setInt(2, quiz.getS().getSubjectId());
            ps.setInt(3, quiz.getSs().getSettingId());
            ps.setInt(4, 1);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("question_id");
                String content = rs.getString("question");
                Question ques = new Question();
                ques.setQuestionId(id);
                ques.setQuestion(content);
                questionListToAdd.add(ques);
            }
            return questionListToAdd;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public String getSubjectName(String subjectId) {
        String sql = "select subject_name \n"
                + "from subject\n"
                + "where subject.subject_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, subjectId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getString("subject_name");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public String getChapterName(String chapterId) {
        String sql = "select setting_name\n"
                + "from subject_setting\n"
                + "where setting_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, chapterId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getString("setting_name");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }

    public void deleteQuizByID(String quizID) {
        String sql = "DELETE FROM quiz_question WHERE (`quiz_id` = '" + quizID + "');";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

        sql = "DELETE FROM quiz WHERE (`quiz_id` = '" + quizID + "');";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteQuesByID(String quesId, String quizId) {
        String sql = "DELETE FROM quiz_question WHERE (`question_id` = '" + quesId + "') AND `quiz_id` = '" + quizId + "';";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateTotal(String quizId) {
        String sql = "UPDATE quiz SET number_of_question = number_of_question - 1 where quiz_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, quizId);
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void addQuiz(Quiz quiz) {
        String sql = "INSERT INTO `quiz`(`quiz_name`, `subject_id`, `chapter_id`, `quiz_type`, `number_of_question`, `status`, `quiz_time`, `create_at`, `create_by`, `update_at`, `update_by`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, quiz.getQuizName());
            st.setInt(2, quiz.getSubjectId());
            st.setInt(3, quiz.getChapterId());
            st.setBoolean(4, quiz.isQuizType());
            st.setInt(5, quiz.getNumberQuestion());
            st.setBoolean(6, quiz.isStatus());
            st.setInt(7, quiz.getQuizTime());
            st.setTimestamp(8, new Timestamp(quiz.getCreateAt().getTime()));
            st.setInt(9, quiz.getCreateBy());
            st.setTimestamp(10, new Timestamp(quiz.getUpdateAt().getTime()));
            st.setInt(11, quiz.getUpdateBy());
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(QuizDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int getNewQuizID() {
        String sql = "SELECT  quiz_id FROM quiz\n"
                + "ORDER BY quiz_id DESC \n"
                + "LIMIT 1;";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt("quiz_id");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return -1;
    }

    public void addQuestionToQuiz(String quizId, ArrayList<Integer> listQuestionId, int isFixed) {
        try {
            for (int i = 0; i < listQuestionId.size(); i++) {
                String sql = "INSERT INTO quiz_question (quiz_id, question_id)\n"
                        + "SELECT * FROM (SELECT " + quizId + " AS quiz_id, " + listQuestionId.get(i) + " AS question_id) AS temp\n"
                        + "WHERE NOT EXISTS (\n"
                        + "    SELECT * FROM quiz_question\n"
                        + "    WHERE quiz_id = " + quizId + " AND question_id = " + listQuestionId.get(i) + "\n"
                        + ")";

                PreparedStatement st = connection.prepareStatement(sql);
                st.executeUpdate();
            }

            if (isFixed != 0) {
                String sql = "UPDATE quiz SET number_of_question = number_of_question + ? WHERE quiz_id = ?";

                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setInt(1, listQuestionId.size()); // tăng lên số câu hỏi đã thêm
                stmt.setString(2, quizId);
                stmt.executeUpdate();
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public ArrayList<Integer> geAllQuestionIdByChapterSubject(Quiz quiz) {
        ArrayList<Integer> questionIdList = new ArrayList<>();
        String sql = "SELECT question_id FROM question WHERE subject_id = ? And chapter_id = ? AND flag = 1";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, quiz.getS().getSubjectId());
            ps.setInt(2, quiz.getSs().getSettingId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("question_id");
                questionIdList.add(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questionIdList;
    }

    public void activeAndDeactive(Quiz quiz) {
        String sql = "UPDATE quiz SET  \n"
                + "`status`=?,`update_by`=?,`update_at`=NOW()"
                + "where quiz_id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setBoolean(1, quiz.isStatus());
            st.setInt(2, quiz.getUpdateBy());
            st.setInt(3, quiz.getQuizId());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateQuiz(Quiz quiz) {
        String sql = "UPDATE quiz SET  \n"
                + "`quiz_name`=?,`number_of_question`=?,"
                + "`update_by`=?,`update_at`=NOW() "
                + "where quiz_id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, quiz.getQuizName());
            st.setInt(2, quiz.getNumberQuestion());
            st.setInt(3, quiz.getUpdateBy());
            st.setInt(4, quiz.getQuizId());

            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public Quiz getPracticeQuizByUser(int userId, int subjectId) {
        String sql = "SELECT q.quiz_id,q.quiz_name, ss.setting_type, ss.setting_name,qc.number_of_question, qr.start_time,qr.total_time,qr.correct_count FROM quiz q, quiz_config qc, subject_setting ss, quiz_result qr WHERE qr.quiz_id=q.quiz_id AND q.create_by = ? AND q.quiz_id= qc.quiz_id and qc.setting_id =ss.setting_id AND q.subject_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, userId);
            st.setInt(2, subjectId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Quiz q = new Quiz();
                SubjectSetting ss = new SubjectSetting();
                QuizConfig qc = new QuizConfig();
                QuizResult qr = new QuizResult();
                q.setQuizId(rs.getInt("quiz_id"));
                q.setQuizName(rs.getString("quiz_name"));
                ss.setSettingId(rs.getInt("setting_type"));
                ss.setSettingName(rs.getString("setting_name"));
                qc.setNumberOfQuestion(rs.getInt("number_of_question"));
                qr.setStartTime(rs.getTimestamp("start_time"));
                qr.setTotalTime(rs.getTime("total_time"));
                qr.setCorrectCount(rs.getInt("correct_count"));
                q.setSs(ss);
                q.setQc(qc);
                q.setQr(qr);
                return q;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public List<Quiz> getAllQuizPractice(int uid, int sid) {
        List<Quiz> quizList = new ArrayList<>();
        String sql = "SELECT q.quiz_id,q.quiz_name, ss.setting_type, ss.setting_name,qc.number_of_question, qr.start_time,qr.total_time,qr.correct_count FROM quiz q, quiz_config qc, subject_setting ss, quiz_result qr WHERE qr.quiz_id=q.quiz_id AND q.create_by = ? AND q.quiz_id= qc.quiz_id and qc.setting_id =ss.setting_id AND q.subject_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, uid);
            st.setInt(2, sid);
            ResultSet result = st.executeQuery();
            while (result.next()) {
                int quiz_id = result.getInt(1);
                String quiz_name = result.getString(2);
                String setting_type = result.getString(3);
                String setting_name = result.getString(4);
                int number_of_question = result.getInt(5);
                Timestamp start_time = result.getTimestamp(6);
                Time total_time = result.getTime(7);
                int correct_count = result.getInt(8);
                SubjectSetting ss = new SubjectSetting(setting_type, setting_name);
                QuizConfig qc = new QuizConfig(number_of_question);
                QuizResult qr = new QuizResult(start_time, total_time, correct_count);
                Quiz quiz = new Quiz(quiz_id, quiz_name, ss, qc, qr);
                quizList.add(quiz);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return quizList;
    }

    public static void main(String[] args) {
        List<Quiz> list = new ArrayList<>();
        QuizDAO dao = new QuizDAO();
        list = dao.getAllQuizPractice(3, 2);
        for (Quiz quiz : list) {
            System.out.println(quiz);
        }
    }


}
