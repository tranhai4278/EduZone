package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

}
