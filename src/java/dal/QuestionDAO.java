/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.util.ArrayList;
import model.Question;

/**
 *
 * @author MinhDQ
 */
public class QuestionDAO extends MySqlConnection{
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
    
    
}
