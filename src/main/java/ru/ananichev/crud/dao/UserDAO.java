package ru.ananichev.crud.dao;

import org.springframework.stereotype.Repository;
import ru.ananichev.crud.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveUser(User user) {
        entityManager.persist(user);
    }

    public void removeUserById(long id) {
        entityManager.createQuery("DELETE FROM User WHERE id = :id").setParameter("id", id).executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT user FROM User user").getResultList();
    }

    public void updateUser(User user, long id) {
        entityManager.createQuery("UPDATE User SET name = :name, lastName = :lastName, age = :age WHERE id = :id")
                .setParameter("name", user.getName())
                .setParameter("lastName", user.getLastName())
                .setParameter("age", user.getAge())
                .setParameter("id", user.getId())
                .executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public User getUser(long id) {
        return entityManager.createQuery("SELECT user FROM User user WHERE user.id = :id", User.class)
                .setParameter("id", id).getSingleResult();
    }


}
