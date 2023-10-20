/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.SubjectSetting;

/**
 *
 * @author MinhDQ
 */
public class SubjectSettingDAO extends MySqlConnection{
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
