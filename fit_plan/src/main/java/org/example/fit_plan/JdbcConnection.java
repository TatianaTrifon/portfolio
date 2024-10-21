package org.example.fit_plan;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

    private static final String url = "jdbc:mysql://localhost:3306/fitness_plan";

    private static final String username = "root";

    private static final String password = "123456789";


public Connection getConnection() throws SQLException {
    return DriverManager.getConnection(url,username,password);
}


}
