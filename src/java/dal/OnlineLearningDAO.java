/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.Lesson;
import model.QuestionChoise;
import model.Quiz;
import model.Question;
import model.Class;

/**
 *
 * @author Nết
 */
public class OnlineLearningDAO extends MySqlConnection {

    public List<Lesson> getLessonbyChapter(int sid, int classid) {
        List<Lesson> list = new ArrayList<>();
        String sql = " SELECT * FROM `lesson` WHERE `chapter_id`=? and (class_id is null or class_id =?) ORDER BY `lesson`.`display_order` ASC";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, sid);
            statement.setInt(2, classid);
            result = statement.executeQuery();
            while (result.next()) {
                Lesson s = new Lesson(result.getInt(1),
                        result.getString(2),
                        result.getInt(3),
                        result.getInt(4),
                        result.getString(5),
                        result.getInt(6),
                        result.getString(7),
                        result.getString(8),
                        result.getBoolean(9),
                        result.getString(10),
                        result.getDate(11),
                        result.getDate(12),
                        result.getInt(13),
                        result.getDate(14),
                        result.getInt(15),
                        result.getDate(16),
                        result.getInt(17));
                list.add(s);

            }
        } catch (SQLException e) {

        }
        return list;
    }

    public Lesson getLessonbyId(int lid) {
        Lesson p = null;
        String sql = " SELECT * FROM `lesson` WHERE `lesson_id` =?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, lid);
            result = statement.executeQuery();
            while (result.next()) {
                p = new Lesson(result.getInt(1),
                        result.getString(2),
                        result.getInt(3),
                        result.getInt(4),
                        result.getString(5),
                        result.getInt(6),
                        result.getString(7),
                        result.getString(8),
                        result.getBoolean(9),
                        result.getString(10),
                        result.getDate(11),
                        result.getDate(12),
                        result.getInt(13),
                        result.getDate(14),
                        result.getInt(15),
                        result.getDate(16),
                        result.getInt(17));

            }
        } catch (SQLException e) {

        }
        return p;
    }

    public List<Question> getQuestion(int qid) {
        List<Question> list = new ArrayList<>();
        String sql = "SELECT que.* FROM question que, quiz_question qq, quiz q WHERE q.quiz_id=qq.quiz_id and qq.question_id=que.question_id and q.quiz_id=?";

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, qid);

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
            return null;
        }
    }

    public List<QuestionChoise> getChoice(int qid) {
        List<QuestionChoise> list = new ArrayList<>();
        String sql = " SELECT qc.* FROM question_choice qc WHERE qc.question_id=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, qid);
            result = statement.executeQuery();
            while (result.next()) {
                QuestionChoise s = new QuestionChoise(result.getInt(1),
                        result.getString(2),
                        result.getInt(3),
                        result.getBoolean(4)
                );
                list.add(s);

            }
        } catch (SQLException e) {

        }
        return list;
    }

    public Quiz getQuizbyId(int qid) {
        Quiz q = null;
        String sql = " SELECT * FROM quiz q WHERE q.quiz_id=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, qid);
            result = statement.executeQuery();
            while (result.next()) {
                q = new Quiz(result.getInt(1),
                        result.getString(2),
                        result.getInt(3),
                        result.getInt(4), result.getBoolean(5), result.getInt(6), result.getBoolean(7), result.getInt(8), result.getDate(9), result.getInt(10), result.getDate(11), result.getInt(12));

            }
        } catch (SQLException e) {

        }
        return q;
    }

    public List<Quiz> getQuizbySubject(int sid) {
        List<Quiz> list = new ArrayList<>();
        String sql = " SELECT * FROM quiz q WHERE q.subject_id=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, sid);
            result = statement.executeQuery();
            while (result.next()) {
                Quiz q = new Quiz(result.getInt(1),
                        result.getString(2),
                        result.getInt(3),
                        result.getInt(4), result.getBoolean(5), result.getInt(6), result.getBoolean(7), result.getInt(8), result.getDate(9), result.getInt(10), result.getDate(11), result.getInt(12));
                list.add(q);
            }
        } catch (SQLException e) {

        }
        return list;

    }

    public List<Class> getClassbyUser(int uid) {
        List<Class> list = new ArrayList<>();
        String sql1 = "SELECT u.role_id FROM user u WHERE user_id=?";
        try {
            PreparedStatement st1 = connection.prepareStatement(sql1);
            st1.setInt(1, uid);
            ResultSet rs = st1.executeQuery();
            if (rs.next()) {
                int roleid = rs.getInt("role_id");
                System.out.println(roleid);
                String sql2 = "";
                if (roleid == 4) {
                    sql2 = "SELECT c.* FROM class c, user u, class_student cs WHERE 1=1 and u.user_id=cs.trainee_id and u.user_id=? and c.class_id = cs.class_id";
                } else if (roleid == 3) {
                    sql2 = "SELECT c.* FROM class c WHERE 1=1 and c.trainer_id=?";
                }
                PreparedStatement statement = connection.prepareStatement(sql2);
                statement.setInt(1, uid);
                ResultSet result = statement.executeQuery();
                System.out.println(sql2);
                while (result.next()) {
                    Class c = new Class(result.getInt(1), result.getString(2), result.getInt(3), result.getInt(4), result.getInt(5), result.getBoolean(6), result.getDate(7), result.getInt(8), result.getDate(9), result.getInt(10));
                    list.add(c);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý lỗi, ví dụ: in lỗi ra màn hình hoặc ghi vào logs
        }
        return list;
    }

    public void extraLesson(Lesson s) {
        String sql = "INSERT INTO `lesson`(`title`, `chapter_id`, `class_id`, `lesson_type`, `quiz_id`, `video_link`, "
                + "`file`, `status`, `description`, `start_date`, `end_date`, `display_order`, `create_at`, `create_by`, `update_at`, `update_by`) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, s.getTitle());
            statement.setInt(2, s.getChapterId());
            statement.setInt(3, s.getClassId());
            statement.setString(4, s.getLessonType());
            statement.setInt(5, s.getQuizId());
            statement.setString(6, s.getVideoLink());
            statement.setString(7, s.getFile());
            statement.setBoolean(8, s.isStatus());
            statement.setString(9, s.getDescription());
            statement.setTimestamp(10,  new Timestamp(s.getUpdateAt().getTime()));
            statement.setTimestamp(11,  new Timestamp(s.getUpdateAt().getTime()));
            statement.setInt(12, s.getDisplayOrder());
            statement.setTimestamp(13, new Timestamp(s.getUpdateAt().getTime()));
            statement.setInt(14, s.getUpdateBy());
            statement.setTimestamp(15, new Timestamp(s.getCreateAt().getTime()));
            statement.setInt(16, s.getUpdateBy());
            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }
     public void deleteExtraLesson(int lid) {
        String sql = "DELETE FROM `lesson` WHERE `lesson_id`=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, lid);
            statement.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public static void main(String[] args) {
        OnlineLearningDAO dao = new OnlineLearningDAO();
        List<Class> listQ = dao.getClassbyUser(5);
        System.out.println(listQ);
    }
}
