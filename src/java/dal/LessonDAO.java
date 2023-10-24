/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Lesson;

public class LessonDAO extends MySqlConnection{
    public ArrayList getAllLessons() {
        ArrayList<Lesson> list = new ArrayList<>();
        String sql = "select * from lesson";

        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();

            while (result.next()) {
                int lessonId = result.getInt(1);
                String title = result.getString(2);
                int chapterId = result.getInt(3);
                int classId = result.getInt(4);
                String lessonType = result.getString(5);
                int quizId = result.getInt(6);
                String videoLink = result.getString(7);
                String file = result.getString(8);
                boolean status = result.getBoolean(9);
                String description = result.getString(10);
                Date create_at = result.getDate(11);
                int create_by = result.getInt(12);
                Date update_at = result.getDate(13);
                int update_by = result.getInt(14);
                Lesson l = new Lesson(lessonId, title, chapterId, classId, lessonType, quizId, videoLink, file, status, description, create_at, create_by, update_at, update_by);
                list.add(l);
            }
            return list;

        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public String getChapterName(int lessonId){
        String query = "SELECT ss.setting_name FROM lesson l JOIN subject_setting ss ON l.chapter_id = ss.setting_id WHERE l.lesson_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, lessonId);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return result.getString("setting_name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String getSubjectName(int lessonId){
        String query = "SELECT subject.subject_name FROM lesson JOIN subject_setting ON lesson.chapter_id = subject_setting.setting_id JOIN subject ON subject.subject_id = subject_setting.subject_id WHERE lesson.lesson_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, lessonId);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return result.getString("subject_name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String getQuizName(int lessonId){
        String query = "SELECT quiz.quiz_name FROM lesson JOIN quiz ON lesson.quiz_id = quiz.quiz_id WHERE lesson_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, lessonId);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                return result.getString("quiz_name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Lesson getLessonById(String id) {
        String query = "SELECT * FROM `lesson` WHERE lesson_id = ?";
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            try ( ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Lesson lesson = new Lesson();
                    lesson.setLessonId(resultSet.getInt(1));
                    lesson.setTitle(resultSet.getString(2));
                    lesson.setChapterId(resultSet.getInt(3));
                    lesson.setClassId(resultSet.getInt(4));
                    lesson.setLessonType(resultSet.getString(5));
                    lesson.setQuizId(resultSet.getInt(6));
                    lesson.setVideoLink(resultSet.getString(7));
                    lesson.setFile(resultSet.getString(8));
                    lesson.setStatus(resultSet.getBoolean(9));
                    lesson.setDescription(resultSet.getString(10));
                    lesson.setCreateAt(resultSet.getDate(11));
                    lesson.setCreateBy(resultSet.getInt(12));
                    lesson.setUpdateAt(resultSet.getDate(13));
                    lesson.setUpdateBy(resultSet.getInt(14));
                    return lesson;
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {

        }
        return null;
    }
    
    public void updateLessonById (String title, String type, String description, String video, String quiz, String file , int status, String id) {
        MySqlConnection dbContext = new MySqlConnection();
        try {
            String sql = "UPDATE lesson SET title = ?, status = ?, description = ?, video_link = ?, quiz_id = ?, file = ? WHERE lesson_id = ?;";
            PreparedStatement preparedStatement = dbContext.connection.prepareStatement(sql);
            preparedStatement.setString(1, title);
            preparedStatement.setInt(2, status);
            preparedStatement.setString(3, description);
            if (type.equals("Video")) {
                preparedStatement.setString(4, video);
                preparedStatement.setNull(5, java.sql.Types.VARCHAR); // Quiz
                preparedStatement.setNull(6, java.sql.Types.VARCHAR); // Assignment
            } else if (type.equals("Quiz")) {
                preparedStatement.setNull(4, java.sql.Types.VARCHAR); // Video
                preparedStatement.setString(5, quiz);
                preparedStatement.setNull(6, java.sql.Types.VARCHAR); // Assignment
            } else if (type.equals("Assignment")) {
                preparedStatement.setNull(4, java.sql.Types.VARCHAR); // Video
                preparedStatement.setNull(5, java.sql.Types.VARCHAR); // Quiz
                preparedStatement.setString(6, file);
            }
            preparedStatement.setString(7, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            dbContext.connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args) {
        LessonDAO dao = new LessonDAO();
        System.out.println(dao.getQuizName(2));
    }
    
}
    
    
   
    

