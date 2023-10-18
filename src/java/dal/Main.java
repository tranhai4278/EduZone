package dal;

public class Main {

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

