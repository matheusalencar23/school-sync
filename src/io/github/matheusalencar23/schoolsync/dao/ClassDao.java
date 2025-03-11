package io.github.matheusalencar23.schoolsync.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import io.github.matheusalencar23.schoolsync.db.DbConnectionFactory;
import io.github.matheusalencar23.schoolsync.model.Class;

public class ClassDao {
    public List<Class> getClassesByPersonId(Integer personId) {
        String sql = "select * from students s \n" + //
                "left join classes_students cs on cs.student_id = s.id\n" + //
                "left join classes c on c.id = cs.class_id \n" + //
                "left join people p on p.id = s.person_id\n" + //
                "where p.id = ?;";

        try (Connection conn = DbConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, personId);
            ResultSet rs = stmt.executeQuery();

            ArrayList<Class> classes = new ArrayList<>();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                Integer teacherId = rs.getInt("teacher_id");
                Class classItem = new Class(id, title, description, teacherId);
                classes.add(classItem);
            }

            return classes;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
