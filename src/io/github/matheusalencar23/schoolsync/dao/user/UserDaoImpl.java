package io.github.matheusalencar23.schoolsync.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.github.matheusalencar23.exceptions.ResourceNotFoundException;
import io.github.matheusalencar23.schoolsync.db.DbConnectionFactory;
import io.github.matheusalencar23.schoolsync.model.User;

public class UserDaoImpl implements UserDao {

    @Override
    public User findByUsername(String username) throws RuntimeException {
        String sql = "select * from user where username = ?";

        try {
            Connection conn = DbConnectionFactory.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new User(rs.getInt("id"), rs.getString("username"), "", rs.getString("user_role"));
            } else {
                throw new ResourceNotFoundException("User not found with username: " + username);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
