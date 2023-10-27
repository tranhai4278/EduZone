/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Quiz;
import model.Subject;

/**
 *
 * @author MinhDQ
 */
public class QuizDAO extends MySqlConnection {

    public ArrayList<Quiz> getAllQuiz() {
    ArrayList<Quiz> list = new ArrayList<>();
    String sql = "SELECT * FROM quiz"; // Modify the SQL query to select from the "quiz" table

    try {
        statement = connection.prepareStatement(sql);
        result = statement.executeQuery();

        while (result.next()) {
            int quizId = result.getInt(1);
            String quizName = result.getString(2);
            int subjectId = result.getInt(3);
            Date createAt = result.getDate(4);
            int createBy = result.getInt(5);
            Date updateAt = result.getDate(6);
            int updateBy = result.getInt(7);
            boolean quizType = result.getBoolean(8);
            int numberQuestion = result.getInt(9);

            Quiz quiz = new Quiz(quizId, quizName, subjectId, createAt, createBy, updateAt, updateBy, quizType, numberQuestion);
            list.add(quiz);
        }
        return list;
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
    }
    
    public ArrayList<Quiz> getAllQuizes() {
    ArrayList<Quiz> list = new ArrayList<>();
    String sql = "SELECT * FROM quiz"; // Modify the SQL query to select from the "quiz" table

    try {
        statement = connection.prepareStatement(sql);
        result = statement.executeQuery();

        while (result.next()) {
            int quizId = result.getInt(1);
            String quizName = result.getString(2);
            int subjectId = result.getInt(3);
            

            Quiz quiz = new Quiz(quizId, quizName, subjectId);
            list.add(quiz);
        }
        return list;
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
    }
     
    public static void main(String[] args) {
        ArrayList<Quiz> list = new ArrayList<>();
        QuizDAO dao = new QuizDAO();
        list = dao.getAllQuizes();
        for (Quiz quiz : list) {
            System.out.println(quiz);
        }
    }
}



