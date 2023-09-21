package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlConnection {

    protected Connection connection;
    protected PreparedStatement statement;
    protected ResultSet result;

    public MySqlConnection() {
        String url = "jdbc:mysql://localhost:3306/eduzone";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connect successfully!");
        } catch (Exception ex) {
            System.out.println("Connect failure!");
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
        try {
            System.out.println(new MySqlConnection().connection);
        } catch (Exception e) {
        }
    }
}
