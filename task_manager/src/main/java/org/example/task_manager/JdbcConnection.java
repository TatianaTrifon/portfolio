package org.example.task_manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

    private static String url = "jdbc:mysql://localhost:3306/task_manager";

    private static String username = "root";

    private static String password = "123456789";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

}
