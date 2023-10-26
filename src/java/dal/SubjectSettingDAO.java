/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.SubjectSetting;

/**
 *
 * @author MinhDQ
 */
public class SubjectSettingDAO extends MySqlConnection {

    public List<SubjectSetting> getAllChapterNamesBySubjectId(String name) {
        List<SubjectSetting> list = new ArrayList<>();
        String sql = "SELECT setting_name FROM `subject_setting` WHERE display_order = 1 and subject_name=" + name;

        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();

            while (result.next()) {
                String settingName = result.getString(1);
                SubjectSetting st = new SubjectSetting(settingName);
                list.add(st);
            }
            return list;
        } catch (Exception e) {
            e.getStackTrace();
            return null;
        }
    }

    public ArrayList<SubjectSetting> getSubjectSettingByQuestionId(int questionId) {
        ArrayList<SubjectSetting> list = new ArrayList<>();
        String sql = "SELECT ss.*\n"
                + "FROM subject_setting ss\n"
                + "JOIN question_dimension qd ON qd.dimension_id = ss.setting_id\n"
                + "WHERE qd.question_id = " + questionId + "";

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
                boolean status = result.getInt(7) != 0;
                Date createAt = result.getDate(8);
                int createBy = result.getInt(9);
                Date updateAt = result.getDate(10);
                int updateBy = result.getInt(11);
                SubjectSetting st = new SubjectSetting(settingId, subjectId, settingType, settingName, description, displayOrder, status, createAt, createBy, updateAt, updateBy);
                list.add(st);
            }

            return list;
        } catch (Exception e) {
            return null;
        }
    }

//    public static void main(String[] args) {
//        SubjectSettingDAO stDAO = new SubjectSettingDAO();
//        List<SubjectSetting> chapdao = stDAO.getAllChapterNamesBySubjectId(1);
//
//        if (chapdao != null) {
//            for (SubjectSetting chap : chapdao) {
//                System.out.println(chap);
//            }
//        } else {
//            System.out.println("Failed to retrieve quiz list.");
//        }
//    }
}
