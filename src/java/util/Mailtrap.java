package util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mailtrap {

    public static boolean sendPasswordResetEmail(String userEmail) {
        final String username = "51d141bc93e9bc"; // Replace with your Mailtrap username
        final String password = "4d1447e90c948f"; // Replace with your Mailtrap password

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

            // Set the email subject and content
            message.setSubject("Password Reset Request");
            message.setText("You have requested a password reset. Click on the link to reset your password.");

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
}
