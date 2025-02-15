package io.github.matheusalencar23.schoolsync.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionFactory {
    private static Connection conn;

    public static Connection getConnection() {

        try {
            if (conn != null && !conn.isClosed()) {
                return conn;
            }

            final String url = "jdbc:mysql://localhost:3306/school-sync-db";
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
