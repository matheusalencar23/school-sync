package io.github.matheusalencar23.schoolsync.dao.user;

import io.github.matheusalencar23.schoolsync.model.User;

public interface UserDao {
    User findByUsername(String username);
}
