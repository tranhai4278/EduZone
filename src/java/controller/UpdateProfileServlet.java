package controller;

import model.User;
import dal.UserDAO;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.EmailChecker;
import utils.PhoneNumberChecker;

public class UpdateProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDAO userDao = new UserDAO();

        // Get the updated user information from the form
        String StringID = request.getParameter("id");
        int id = Integer.parseInt(StringID);
        String fullName = request.getParameter("full_name");
        String email = request.getParameter("email");
        String genderString = request.getParameter("gender"); // Get gender as a string
        String phone = request.getParameter("phone_number");
        String avatarUrl = request.getParameter("avatar_url"); // Get the avatar URL

        // Check if any required field is empty
        if (fullName.isEmpty() || email.isEmpty() || genderString.isEmpty() || phone.isEmpty() || avatarUrl.isEmpty()) {
            // Handle the case where any of the required fields is empty
            System.out.println("One or more required fields are empty");
            request.setAttribute("error", "One or more required fields are empty");
            User user = userDao.getUserById(id);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/userprofile.jsp").forward(request, response); // Forward to the profile page
            return; // Stop processing
        }

        PhoneNumberChecker phoneNumberChecker = new PhoneNumberChecker();
        EmailChecker emailChecker = new EmailChecker();

        if (!phoneNumberChecker.isNumeric(phone)) {
            // Handle the case where the phone number is not numeric
            System.out.println("Phone number is not numeric");
            request.setAttribute("error", "Phone number is not numeric");
            User user = userDao.getUserById(id);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/userprofile.jsp").forward(request, response);
            return; // Stop processing
        }

        if (!emailChecker.isValidEmail(email)) {
            // Handle the case where the email is not in the correct format
            System.out.println("Email is not in the correct format");
            request.setAttribute("error", "Email is not in the correct format");
            User user = userDao.getUserById(id);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/userprofile.jsp").forward(request, response);
            return; // Stop processing
        }

        // Check for existing email and phone number duplicates, excluding the user's own email and phone number
        User existingUserByEmail = userDao.getUserByEmail(email);
        User existingUserByPhone = userDao.getUserByPhone(phone);

        if (existingUserByEmail != null && existingUserByEmail.getUserId() != id) {
            // Handle the case where the email already exists (excluding the current user)
            System.out.println("Email already exists");
            request.setAttribute("error", "Email already exists");
            User user = userDao.getUserById(id);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/userprofile.jsp").forward(request, response);
            return; // Stop processing
        }

        if (existingUserByPhone != null && existingUserByPhone.getUserId() != id) {
            // Handle the case where the phone number already exists (excluding the current user)
            System.out.println("Phone number already exists");
            request.setAttribute("error", "Phone number already exists");
            User user = userDao.getUserById(id);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/userprofile.jsp").forward(request, response);
            return; // Stop processing
        }

        // Parse gender as an integer
        int genderValue = Integer.parseInt(genderString);
        boolean gender = (genderValue == 1); // Convert to boolean (1 for Male, 0 for Female)
        System.out.println("Gender received: " + gender);

        // Create a User object with the new information, including the avatar URL
        User updatedUser = new User();
        updatedUser.setUserId(id);
        updatedUser.setFullName(fullName);
        updatedUser.setEmail(email);
        updatedUser.setGender(gender);
        updatedUser.setPhone(phone);
        updatedUser.setAvatarUrl(avatarUrl); // Set the avatar URL

        // Call the DAO method to update the user in the database
        boolean updated = userDao.updateUser(updatedUser);

        if (updated) {
            // User profile updated successfully
            System.out.println("Profile updated successfully");
            // Set a success message attribute
            request.setAttribute("success", "Profile updated successfully");
            User user = userDao.getUserById(id);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/userprofile.jsp").forward(request, response); // Forward to the profile page
        } else {
            // Error occurred during the update
            // You can set an error message and redirect to the profile page
            System.out.println("Failed to update profile");
            request.setAttribute("error", "Failed to update profile");
            User user = userDao.getUserById(id);
            request.setAttribute("user", user);
            request.getRequestDispatcher("/userprofile.jsp").forward(request, response); // Forward to the profile page
        }
    }

    @Override
    public String getServletInfo() {
        return "Update Profile Servlet";
    }
}
