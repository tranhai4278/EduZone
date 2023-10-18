package utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.Properties;

public class Mailtrap {

    public static boolean sendPasswordResetEmail(String userEmail) {
        final String username = "69842ba7772f9c"; // Replace with your Mailtrap username
        final String password = "aa288898d12b0a"; // Replace with your Mailtrap password

        // Generate a unique token that includes a timestamp
        String timestamp = String.valueOf(new Date().getTime());

        // Create a hash of the token for security
        String resetToken = hashToken(username + timestamp);

        // Configure SMTP properties for Mailtrap
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.mailtrap.io");
        props.put("mail.smtp.port", "587");

        // Create a Session with authentication
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a MimeMessage
            Message message = new MimeMessage(session);

            // Set the sender (from) address
            message.setFrom(new InternetAddress(username));

            // Set the recipient (to) address
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail));

            // Set the email subject
            message.setSubject("Password Reset Request");

            // Create the password reset link with the user's email and reset token as query parameters
            String resetLink = "http://localhost:9999/eduzone/resetpasswordfinal.jsp?email=" + userEmail +
                    "&token=" + resetToken;

            // Set the email content with the link
            message.setText("You have requested a password reset. Click on the link below to reset your password:\n"
                    + resetLink);

            // Send the email
            Transport.send(message);

            // Email sent successfully
            return true;

        } catch (MessagingException e) {
            // Handle any exceptions that may occur
            e.printStackTrace();
            // Email sending failed
            return false;
        }
    }

    private static String hashToken(String token) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(token.getBytes());
            return Base64.getEncoder().encodeToString(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            // Handle hashing exception
            e.printStackTrace();
            return null;
        }
    }
}
