package io.github.matheusalencar23.schoolsync.service;

import io.github.matheusalencar23.schoolsync.dao.PersonDao;
import io.github.matheusalencar23.schoolsync.model.Person;

public class PersonService {
    public Person findById(Integer id) throws RuntimeException {
        PersonDao personDao = new PersonDao();
        return personDao.findById(id);
    }
}
