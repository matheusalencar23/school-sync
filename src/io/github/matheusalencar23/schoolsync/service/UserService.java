package io.github.matheusalencar23.schoolsync.service;

import io.github.matheusalencar23.schoolsync.dao.user.UserDao;
import io.github.matheusalencar23.schoolsync.dao.user.UserDaoImpl;
import io.github.matheusalencar23.schoolsync.exceptions.InvalidCredentials;
import io.github.matheusalencar23.schoolsync.model.User;
import io.github.matheusalencar23.schoolsync.utils.CryptUtils;

public class UserService {

    public User login(String username, String password) {
        UserDao userDao = new UserDaoImpl();
        User user = userDao.findByUsername(username);

        if (!CryptUtils.verify(password, user.getPassword())) {
            throw new InvalidCredentials(password);
        }

        return user;
    }
}
