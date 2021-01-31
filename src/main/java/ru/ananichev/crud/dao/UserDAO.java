package ru.ananichev.crud.dao;

import ru.ananichev.crud.model.User;

import java.util.List;

public interface UserDAO {
    void saveUser(User user);

    void removeUserById(long id);

    List<User> getAllUsers();

    void updateUser(User user, long id);

    User getUser(long id);
}
