/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author admin
 */
public class EmailChecker {
    public boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        // Replace with your email format validation logic
        // For a basic check, you can use a regular expression
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}
