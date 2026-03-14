package java_advanced_interface_jdbc.entity;

import java.sql.Connection;
import java.sql.DriverManager;

public class gymconnection {

    private static final String URL = "jdbc:mysql://localhost:3306/gym-db";
    private static final String USER = "root";
    private static final String PASSWORD = "manas";

    public static Connection getConnection() {

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}