package io.github.matheusalencar23.schoolsync.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.github.matheusalencar23.schoolsync.db.DbConnectionFactory;
import io.github.matheusalencar23.schoolsync.exceptions.InvalidCredentials;
import io.github.matheusalencar23.schoolsync.model.User;

public class UserDao {

    public User findByUsername(String username) throws RuntimeException {
        String sql = "select * from users where username = ?";

        try (Connection conn = DbConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Integer id = rs.getInt("id");
                String password = rs.getString("password");
                String role = rs.getString("user_role");
                Integer personId = rs.getInt("person_id");
                return new User(id, username, password, role, personId);
            } else {
                throw new InvalidCredentials("User not found with username: " + username);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
