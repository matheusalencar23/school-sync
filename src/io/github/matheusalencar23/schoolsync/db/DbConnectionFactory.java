package io.github.matheusalencar23.schoolsync.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionFactory {
    private static Connection conn;

    public static Connection getConnection() {
        if (conn != null)
            return conn;

        try {
            final String url = "jdbc:mysql://localhost";
            final String user = "admin";
            final String password = "admin";

            conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
