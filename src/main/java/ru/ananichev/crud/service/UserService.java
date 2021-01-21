package ru.ananichev.crud.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ananichev.crud.dao.UserDAO;
import ru.ananichev.crud.model.User;

import java.util.List;

@Service
public class UserService {
    private final UserDAO userDAO;


    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Transactional
    public void removeUserById(long id) {
        userDAO.removeUserById(id);
    }

    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Transactional
    public void updateUser(User user, long id) {
        userDAO.updateUser(user, id);
    }

    @Transactional
    public User getUser(long id) {
        return userDAO.getUser(id);
    }
}
