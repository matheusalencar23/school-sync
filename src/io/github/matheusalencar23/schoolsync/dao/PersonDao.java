package io.github.matheusalencar23.schoolsync.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import io.github.matheusalencar23.schoolsync.db.DbConnectionFactory;
import io.github.matheusalencar23.schoolsync.exceptions.InvalidCredentials;
import io.github.matheusalencar23.schoolsync.model.Person;

public class PersonDao {
    public Person findById(Integer id) throws RuntimeException {
        String sql = "select * from people where id = ?";

        try (Connection conn = DbConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String cpf = rs.getString("cpf");
                Date birthDate = rs.getDate("birth_date");
                return new Person(id, name, cpf, birthDate);
            } else {
                throw new InvalidCredentials("Person not found with id: " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
