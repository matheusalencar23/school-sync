package io.github.matheusalencar23.schoolsync;

import java.sql.Connection;

import io.github.matheusalencar23.schoolsync.db.DbConnectionFactory;

public class App {
    public static void main(String[] args) throws Exception {
        Connection conn = DbConnectionFactory.getConnection();
        System.out.println("DB Connection Successful");

        conn.close();
    }
}
