package dal;

import model.User;

public class Main {

//    public static void main(String[] args) {
//        // Create an instance of UserDAO
//        UserDAO userDAO = new UserDAO();
//
//        // Retrieve a single user from the database
//        User user = userDAO.getUserTest();
//
//        if (user != null) {
//            // Print user information before update
//            System.out.println("User Information Before Update:");
//            System.out.println("User ID: " + user.getUserId());
//            System.out.println("Full Name: " + user.getFullName());
//            System.out.println("Gender: " + (user.isGender() ? "Male" : "Female"));
//            System.out.println("Avatar URL: " + user.getAvatarUrl());
//            System.out.println("Phone Number: " + user.getPhone());
//            System.out.println("Email: " + user.getEmail());
//            System.out.println("Role ID: " + user.getRoleId());
//            System.out.println("Status: " + (user.isStatus() ? "Active" : "Inactive"));
//            System.out.println("Created At: " + user.getCreateAt());
//            System.out.println("Created By: " + user.getCreateBy());
//            System.out.println("Updated At: " + user.getUpdateAt());
//            System.out.println("Updated By: " + user.getUpdateBy());
//
//            // Update user information
//            user.setFullName("Updated Full Name");
//            user.setPhone("1234567890");
//            user.setEmail("updatedemail@example.com");
//            user.setGender(true);
//
//            // Perform the update
//            boolean updateSuccess = userDAO.updateUser(user);
//
//            if (updateSuccess) {
//                System.out.println("\nUser Information After Update:");
//                User updatedUser = userDAO.getUserTest(); // Retrieve the updated user
//                System.out.println("User ID: " + updatedUser.getUserId());
//                System.out.println("Full Name: " + updatedUser.getFullName());
//                System.out.println("Gender: " + (updatedUser.isGender() ? "Male" : "Female"));
//                System.out.println("Avatar URL: " + updatedUser.getAvatarUrl());
//                System.out.println("Phone Number: " + updatedUser.getPhone());
//                System.out.println("Email: " + updatedUser.getEmail());
//                System.out.println("Role ID: " + updatedUser.getRoleId());
//                System.out.println("Status: " + (updatedUser.isStatus() ? "Active" : "Inactive"));
//                System.out.println("Created At: " + updatedUser.getCreateAt());
//                System.out.println("Created By: " + updatedUser.getCreateBy());
//                System.out.println("Updated At: " + updatedUser.getUpdateAt());
//                System.out.println("Updated By: " + updatedUser.getUpdateBy());
//            } else {
//                System.out.println("\nUser update failed.");
//            }
//        } else {
//            System.out.println("User not found.");
//        }
//    }
    
    public static void main(String[] args) {
        // Create an instance of UserDAO
        UserDAO userDAO = new UserDAO();

        // Example user ID, current password, and new password
        int userId = 1; // Replace with the actual user ID
        String currentPassword = "newPassword"; // Replace with the actual current password
        String newPassword = "Password"; // Replace with the new password

        // Attempt to change the user's password
        boolean passwordChangeSuccess = userDAO.changePassword(userId, currentPassword, newPassword);

        if (passwordChangeSuccess) {
            System.out.println("Password changed successfully.");
        } else {
            System.out.println("Password change failed. Please check the current password.");
        }
    }
}

