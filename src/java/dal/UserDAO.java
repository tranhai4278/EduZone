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
    
    public User getUserTest() {
        User user = null; // Initialize the user as null
        MySqlConnection dbContext = new MySqlConnection();

        try {
            String sql = "SELECT * FROM user WHERE user_id = 1";
            PreparedStatement preparedStatement = dbContext.connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("full_name");
                boolean gender = resultSet.getBoolean("gender");
                String avatarUrl = resultSet.getString("avatar_url");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                int roleId = resultSet.getInt("role_id");
                boolean status = resultSet.getBoolean("status");
                java.sql.Timestamp createdAtTimestamp = resultSet.getTimestamp("create_at");
                int createBy = resultSet.getInt("create_by");
                java.sql.Timestamp updatedAtTimestamp = resultSet.getTimestamp("update_at");
                int updateBy = resultSet.getInt("update_by");

                // Create a User object with the retrieved data
                user = new User(userId, password, fullName, gender, avatarUrl, phoneNumber, email, roleId, status, createdAtTimestamp, createBy, updatedAtTimestamp, updateBy);
            }

            // Close resources
            resultSet.close();
            preparedStatement.close();
            dbContext.connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return user; // Return the single User object
    }

    public boolean updateUser(User updatedUser) {
        MySqlConnection dbContext = new MySqlConnection();
        boolean success = false;

        try {
            String sql = "UPDATE user SET "
                    + "full_name = ?, "
                    + "email = ?, "
                    + "gender = ?, "
                    + "phone_number = ?, "
                    + "avatar_url = ?, " // Add avatar URL field to the update query
                    + "update_at = CURRENT_TIMESTAMP "
                    + "WHERE user_id = ?";

            PreparedStatement preparedStatement = dbContext.connection.prepareStatement(sql);

            // Set the parameters for the prepared statement
            preparedStatement.setString(1, updatedUser.getFullName());
            preparedStatement.setString(2, updatedUser.getEmail());
            preparedStatement.setBoolean(3, updatedUser.isGender());
            preparedStatement.setString(4, updatedUser.getPhone());
            preparedStatement.setString(5, updatedUser.getAvatarUrl()); // Set the avatar URL
            preparedStatement.setInt(6, updatedUser.getUserId());

            int rowsUpdated = preparedStatement.executeUpdate();

            // Close resources
            preparedStatement.close();
            dbContext.connection.close();

            // Check if the update was successful
            if (rowsUpdated == 1) {
                success = true;
            } else {
                System.err.println("Error: Failed to update user profile.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error: SQL Exception - " + ex.getMessage());
        }

        return success;
    }

    public boolean changePassword(int userId, String currentPassword, String newPassword) {
        MySqlConnection dbContext = new MySqlConnection();
        boolean success = false;

        try {
            // First, check if the current password matches the stored password
            String checkPasswordSql = "SELECT password FROM user WHERE user_id = ? AND password = ?";
            PreparedStatement checkPasswordStatement = dbContext.connection.prepareStatement(checkPasswordSql);
            checkPasswordStatement.setInt(1, userId);
            checkPasswordStatement.setString(2, currentPassword);
            ResultSet passwordResultSet = checkPasswordStatement.executeQuery();

            if (passwordResultSet.next()) {
                // Current password matches, proceed to update the password
                String updatePasswordSql = "UPDATE user SET password = ?, update_at = CURRENT_TIMESTAMP WHERE user_id = ?";
                PreparedStatement updatePasswordStatement = dbContext.connection.prepareStatement(updatePasswordSql);
                updatePasswordStatement.setString(1, newPassword);
                updatePasswordStatement.setInt(2, userId);

                int rowsUpdated = updatePasswordStatement.executeUpdate();

                // Close resources
                updatePasswordStatement.close();

                if (rowsUpdated == 1) {
                    success = true;
                } else {
                    System.err.println("Error: Failed to update password.");
                }
            } else {
                System.err.println("Error: Current password does not match.");
            }

            // Close resources
            passwordResultSet.close();
            checkPasswordStatement.close();
            dbContext.connection.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error: SQL Exception - " + ex.getMessage());
        }

        return success;
    }

    public boolean doesEmailExist(String email) {
        String query = "SELECT COUNT(*) FROM user WHERE email = ?";
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, email);
            try ( ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // If count > 0, email exists; otherwise, it doesn't
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; // Return false if an error occurred
    }

    public boolean doesPhoneNumberExist(String phoneNumber) {
        String query = "SELECT COUNT(*) FROM user WHERE phone_number = ?";
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, phoneNumber);
            try ( ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // If count > 0, phone number exists; otherwise, it doesn't
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; // Return false if an error occurred
    }

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserById(1);
        System.out.println(user.getFullName());
    }
}
