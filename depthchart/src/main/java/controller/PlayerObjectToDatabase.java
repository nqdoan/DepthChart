package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PlayerObjectToDatabase {
    public Connection getConnection() {
        try {
        String username = "";
        String password = "";
        String url = "jdbc:mysql://nqdoandb.celtpg05ihar.us-east-1.rds.amazonaws.com:3306/";
        Connection conn = null;

        conn = DriverManager.getConnection(url, username, password);

        System.out.println("Connected to database");
        return conn;
    } catch (SQLException e) {
        System.out.println("Unable to establish connection");
        Connection returnConn = null;
        return returnConn;
    }
    }
}
/*

    public static void main(String[] args) {
        String host = "jdbc:derby://localhost:1527/Employees";
        String uName = "root";
        String uPass = "password";

        try (Connection conn = DriverManager.getConnection(host, uName, uPass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_QUERY)) {

            while (rs.next()) {
                //read your lines one ofter one
                int id = rs.getInt("id");
                String somePropertyValue = rs.getInt("some_column_name");
                // etc.
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
*/
