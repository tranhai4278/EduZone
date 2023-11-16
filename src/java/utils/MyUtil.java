/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;

/**
 *
 * @author MinhDQ
 */
public class MyUtil {

    Session newSession = null;
    MimeMessage mimeMessage = null;
//Encrypt passwords to SHA-1
    public String toSHA1(String str) {
        String salt = "asjrlkmcoewj@tjle;oxqskjhdjksjf1jurVn";// Làm cho mật khẩu phức tap
        String result = null;

        str = str + salt;
        try {
            byte[] dataBytes = str.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            result = Base64.encodeBase64String(md.digest(dataBytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
//Random OTP   
    public String getCaptcha() {
        Random rand = new Random();
        String str = "0123456789";
        char[] captcha = new char[6];
        for (int i = 0; i < 6; i++) {
            captcha[i] = str.charAt(rand.nextInt(str.length()));
        }
        return String.valueOf(captcha);
    }
    
//send email by maitrap
    public void sendMail(String recepient, String subject, String inboxMessage) throws Exception {

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.mailtrap.io"); // Mailtrap SMTP server
        properties.put("mail.smtp.port", "587"); // Mailtrap port
        String myAccountEmail = "69842ba7772f9c";
        String password = "aa288898d12b0a";
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        Message message = prepareMessage(session, myAccountEmail, recepient, subject, inboxMessage);
        Transport.send(message);
        System.out.println("Message Sent successfully");
    }

    private static Message prepareMessage(Session session, String from, String to, String subject, String inboxMessage) {
        Message message = new MimeMessage(session);
        try {

            message.setFrom(new InternetAddress("Eduzone"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(inboxMessage);
            return message;
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String extractDomain(String email) {
        return StringUtils.substringAfter(email, "@");
    }
    
    public static List<Integer> getRandomNumbers(List<Integer> sourceList, int count) {
        if (count > sourceList.size()) {
            throw new IllegalArgumentException("Số lượng số ngẫu nhiên lớn hơn kích thước danh sách ban đầu.");
        }

        List<Integer> randomNumbers = new ArrayList<>();
        List<Integer> copyList = new ArrayList<>(sourceList); // Tạo một bản sao của danh sách ban đầu

        Random random = new Random();

        for (int i = 0; i < count; i++) {
            int randomIndex = random.nextInt(copyList.size()); // Chọn một chỉ mục ngẫu nhiên
            randomNumbers.add(copyList.get(randomIndex)); // Thêm số tại chỉ mục đó vào danh sách kết quả
            copyList.remove(randomIndex); // Loại bỏ số đã được chọn để tránh trùng lặp
        }

        return randomNumbers;
    }
}
