/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.yourally.repository;

import com.project.yourally.entity.User;
import com.project.yourally.utils.APIResponse;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.io.Serializable;
import org.jvnet.hk2.annotations.Service;

/**
 *
 * @author Admin
 */
@Service
public class UserRepository implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public UserRepository() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        this.entityManager = entityManager;
    }

    public APIResponse setUserData(User user) {

        APIResponse res = new APIResponse();

        entityManager.getTransaction().begin();
        try {
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            res.setCode(1);
            res.setMessage("Registration Success");
            return res;
        } catch (Exception e) {

            res.setCode(0);
            if (e.getMessage().toLowerCase().contains("duplicate")) {
                res.setMessage("Email " + user.Email + " alreeady registered");
            } else {
                res.setMessage(e.getMessage());
            }
            return res;
        } finally {
            entityManager.close();
            // entityManagerFactory.close();
        }

    }

    @Transactional
    public User update(User user) {
        return entityManager.merge(user);
    }

    public User findByUsername(String username) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);
        query.setParameter("username", username);
        return query.getSingleResult();
    }

    public User findByEmail(String email) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.Email = :email", User.class);
        query.setParameter("email", email);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean verifyPassword(String enteredPassword, String storedPassword) {
        return enteredPassword.equals(storedPassword);
    }

    /* Connection conn = null;
    PreparedStatement preparedStatement = null;

    public boolean createUser(User user) throws Exception {
        try {
            DatabaseConnection dbConnection = new DatabaseConnection();
            conn = (Connection) dbConnection;
            String query = "INSERT INTO user (FirstName, LastName, Email,PhoneNumber,Address,Password,IsSeeker,Dateofbirth,Gender,CreatedDate, IsDeleted) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = conn.prepareStatement(query);
            
            preparedStatement.setString(1, user.firstName);
            preparedStatement.setString(2, user.LastName);
            preparedStatement.setString(3, user.Email);
            preparedStatement.setString(4, user.PhoneNumber);
            preparedStatement.setString(5, user.Address);
            preparedStatement.setString(6, user.Password);
            preparedStatement.setBoolean(7, user.IsSeeker);
            preparedStatement.setDate(8, (Date) user.Dateofbirth);
            preparedStatement.setString(9, user.Gender);
            preparedStatement.setDate(10, (Date) user.CreatedDate);
            preparedStatement.setBoolean(11, user.IsDeleted);
            preparedStatement.executeUpdate();
            
            
        } catch (Exception e) {
            throw e;
        }
        return true;
    }*/
    public User findById(Integer UserId) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.UserId = :userid", User.class);
        query.setParameter("userid", UserId);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }
}
