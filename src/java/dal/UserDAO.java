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
import java.util.List;
import model.User;

/**
 *
 * @author MinhDQ
 */
public class UserDAO extends MySqlConnection {

    public ArrayList getAllUser() {
        ArrayList<User> list = new ArrayList<>();
        String sql = "select * from user";
        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();
            while (result.next()) {
                int userId = result.getInt(1);
                String password = result.getString(2);
                String fullName = result.getString(3);
                boolean gender = result.getBoolean(4);
                String avatarUrl = result.getString(5);
                String phoneNumber = result.getString(6);
                String email = result.getString(7);
                int roleId = result.getInt(8);
                boolean status = result.getBoolean(9);
                Date createAt = result.getDate(10);
                int createBy = result.getInt(11);
                Date updateAt = result.getDate(12);
                int updateBy = result.getInt(13);
                User user = new User(userId, password, fullName, gender, avatarUrl, phoneNumber, email, roleId, status, createAt, createBy, updateAt, updateBy);
                list.add(user);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void addUser(User acc) {
        try {
            String strSelect = "INSERT INTO user (user_id, password, full_name, gender, avatar_url, phone_number, email, role_id, \n"
                    + "status, create_at, create_by, update_at, update_by)\n"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            Connection cnn = (new MySqlConnection()).connection;
            PreparedStatement pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, acc.getUserId());
            pstm.setString(2, acc.getPassword());
            pstm.setString(3, acc.getFullName());
            pstm.setBoolean(4, acc.isGender());
            pstm.setString(5, acc.getAvatarUrl());
            pstm.setString(6, acc.getPhone());
            pstm.setString(7, acc.getEmail());
            pstm.setInt(8, acc.getRoleId());
            pstm.setBoolean(9, acc.isStatus());
            java.util.Date d = new java.util.Date();
            java.sql.Date createdAt = new java.sql.Date(d.getTime());
            java.sql.Date updateBy = new java.sql.Date(d.getTime());

            pstm.setDate(10, createdAt);
            pstm.setInt(11, acc.getCreateBy());
            pstm.setDate(12, updateBy);
            pstm.setInt(13, acc.getUpdateBy());
            pstm.execute();

        } catch (Exception e) {
            System.out.println("addAccount: " + e.getMessage());
        }
    }
    
    public void addUser( String pass, String name, boolean gender, String avatar, String phone, String email, int role, int createBy, int updateBy) {
        try {
            String strSelect = "INSERT INTO user ( password, full_name, gender, avatar_url, phone_number, email, role_id, \n"
                    + "status, create_at, create_by, update_at, update_by)\n"
                    + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            Connection cnn = (new MySqlConnection()).connection;
            PreparedStatement pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, pass);
            pstm.setString(2, name);
            pstm.setBoolean(3, gender);
            pstm.setString(4, avatar);
            pstm.setString(5, phone);
            pstm.setString(6, email);
            pstm.setInt(7,role);
            pstm.setBoolean(8, true);
            java.util.Date d = new java.util.Date();
            java.sql.Date createdAt = new java.sql.Date(d.getTime());
            java.sql.Date updatedAt = new java.sql.Date(d.getTime());
            pstm.setDate(9, createdAt);
            pstm.setInt(10, createBy);
            pstm.setDate(11, updatedAt);
            pstm.setInt(12, updateBy);
            pstm.executeUpdate();

        } catch (Exception e) {
            System.out.println("addAccount: " + e.getMessage());
        }
    }

    public User getUserByEmail(String email) {
        String query = "SELECT * FROM user WHERE email = ?";
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            try ( ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    User user = new User();
                    user.setUserId(resultSet.getInt(1));
                    user.setPassword(resultSet.getString(2));
                    user.setFullName(resultSet.getString(3));
                    user.setGender(resultSet.getBoolean(4));
                    user.setAvatarUrl(resultSet.getString(5));
                    user.setPhone(resultSet.getString(6));
                    user.setEmail(resultSet.getString(7));
                    user.setRoleId(resultSet.getInt(8));
                    user.setStatus(resultSet.getBoolean(9));
                    user.setCreateAt(resultSet.getDate(10));
                    user.setCreateBy(resultSet.getInt(11));
                    user.setUpdateAt(resultSet.getDate(12));
                    user.setUpdateBy(resultSet.getInt(13));

                    return user;
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {

        }
        return null;
    }

    public User getUserByPhone(String phone) {
        String query = "SELECT * FROM user WHERE phone_number = ?";
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, phone);
            try ( ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    User user = new User();
                    user.setUserId(resultSet.getInt(1));
                    user.setPassword(resultSet.getString(2));
                    user.setFullName(resultSet.getString(3));
                    user.setGender(resultSet.getBoolean(4));
                    user.setAvatarUrl(resultSet.getString(5));
                    user.setPhone(resultSet.getString(6));
                    user.setEmail(resultSet.getString(7));
                    user.setRoleId(resultSet.getInt(8));
                    user.setStatus(resultSet.getBoolean(9));
                    user.setCreateAt(resultSet.getDate(10));
                    user.setCreateBy(resultSet.getInt(11));
                    user.setUpdateAt(resultSet.getDate(12));
                    user.setUpdateBy(resultSet.getInt(13));

                    return user;
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {

        }
        return null;
    }

    public User getUserById(int userId) {
        User user = new User();
        String sql = "SELECT *\n"
                + "FROM USER\n"
                + "WHERE user_id = " + userId + ";";

        try {
            statement = connection.prepareStatement(sql);
            result = statement.executeQuery();

            while (result.next()) {
                String password = result.getString(2);
                String fullName = result.getString(3);
                boolean gender = result.getBoolean(4);
                String avatarUrl = result.getString(5);
                String phoneNumber = result.getString(6);
                String email = result.getString(7);
                int roleId = result.getInt(8);
                boolean status = result.getBoolean(9);
                Date createAt = result.getDate(10);
                int createBy = result.getInt(11);
                Date updateAt = result.getDate(12);
                int updateBy = result.getInt(13);
                user = new User(
                        userId,
                        password,
                        fullName,
                        gender,
                        avatarUrl,
                        phoneNumber,
                        email,
                        roleId,
                        status,
                        createAt,
                        createBy,
                        updateAt,
                        updateBy);
            }

            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        //UserDAO userDAO = new UserDAO();
        //User user = userDAO.getUserById(1);
        //System.out.println(user.getFullName());
        UserDAO dao = new UserDAO();
        ArrayList<User> list = dao.getAllUser();
        for (User u : list) {
            System.out.println(u);
        }
    }
}
