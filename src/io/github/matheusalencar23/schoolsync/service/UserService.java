package io.github.matheusalencar23.schoolsync.service;

import io.github.matheusalencar23.schoolsync.dao.UserDao;
import io.github.matheusalencar23.schoolsync.exceptions.InvalidCredentials;
import io.github.matheusalencar23.schoolsync.model.Person;
import io.github.matheusalencar23.schoolsync.model.User;
import io.github.matheusalencar23.schoolsync.utils.CryptUtils;

public class UserService {

    public User login(String username, String password) {
        UserDao userDao = new UserDao();
        User user = userDao.findByUsername(username);

        if (!CryptUtils.verify(password, user.getPassword())) {
            throw new InvalidCredentials("Invalid password");
        }

        if (user.getPersonId() != null) {
            PersonService personService = new PersonService();
            Person person = personService.findById(user.getPersonId());

            if (person != null) {
                user.setPerson(person);
            }
        }

        return user;
    }
}
