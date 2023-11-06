/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Lesson;
import model.QuestionChoise;
import model.Quiz;
import model.Question;

/**
 *
 * @author Nết
 */
public class OnlineLearningDAO extends MySqlConnection {

    public List<Lesson> getLessonbyChapter(int sid) {
        List<Lesson> list = new ArrayList<>();
        String sql = " SELECT * FROM `lesson` WHERE `chapter_id`=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, sid);
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

    public static void main(String[] args) {
        OnlineLearningDAO dao = new OnlineLearningDAO();
        List<Question> listQ = dao.getQuestion(1);
        System.out.println(listQ.get(1));
    }
}
