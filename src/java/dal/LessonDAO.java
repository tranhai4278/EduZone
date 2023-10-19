/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
    
}
