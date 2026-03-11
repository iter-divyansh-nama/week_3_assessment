package assessment.week3.task2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL      = "jdbc:mysql://localhost:3306/assessment_week3_jdbc";
    private static final String USER     = "mohit";
    private static final String PASSWORD = "1234";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}