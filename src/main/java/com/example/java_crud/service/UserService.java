package com.example.java_crud.service;

import com.example.java_crud.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;



@Service
public class UserService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public User createUser(User user) {
        entityManager.persist(user);
        return user;
    }

    // start--- i wants to get the all the users here 

    @Transactional(readOnly = true)
    public List<User> getAllUser() {
        return entityManager.createQuery("SELECT u FROM User u", User.class)
                            .getResultList();
    }

    // end of the logic x 


    // update the suer logic goes here
    @Transactional
   public User updateUser(Long id, User updatedUser) {
   
    User existingUser = entityManager.find(User.class, id);
    if (existingUser == null) {
        throw new RuntimeException("User not found with id: " + id);
    }

   
    existingUser.setName(updatedUser.getName());
    existingUser.setEmail(updatedUser.getEmail());
    existingUser.setPassword(updatedUser.getPassword());

   
    entityManager.merge(existingUser);

    return existingUser;
}

}
