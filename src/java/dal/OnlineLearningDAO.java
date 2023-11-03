/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Lesson;

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
                        result.getInt(12),
                        result.getDate(13),
                        result.getInt(14));
                list.add(s);

            }
        } catch (SQLException e) {

        }
        return list;
    }

}
