/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.yourally.repository;

import com.project.yourally.entity.User;
import com.project.yourally.utils.APIResponse;
import com.project.yourally.utils.SendMail;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.io.Serializable;
import java.util.Random;
import org.jvnet.hk2.annotations.Service;
 
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

    public APIResponse updateProfile(User user) {

        APIResponse res = new APIResponse();

        TypedQuery<User> query1 = entityManager.createQuery("Select u from User u where u.UserId =:id", User.class);
        query1.setParameter("id", user.UserId);

        try {
            User user1 = query1.getSingleResult();
            if (user1 != null) {
                user1.Address = user.Address;
                user1.Dateofbirth = user.Dateofbirth;
                user1.FirstName = user.FirstName;
                user1.LastName = user.LastName;
                user1.Gender = user.Gender;
                user1.PhoneNumber = user.PhoneNumber;

                entityManager.getTransaction().begin();
                entityManager.persist(user1);
                entityManager.getTransaction().commit();
                res.setCode(1);
                res.setMessage("Profile Updated");
                return res;
            }
        } catch (Exception e) {
            res.setCode(0);
            if (e.getMessage().toLowerCase().contains("duplicate")) {
                res.setMessage("Email " + user.Email + " alreeady registered");
            } else {
                res.setMessage(e.getMessage());
            }
            e.printStackTrace();
            return res;

        } finally {
            entityManager.close();
            // entityManagerFactory.close();
        }
        return res;
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

    public APIResponse changePassword(User user) {
        APIResponse res = new APIResponse();

        TypedQuery<User> query1 = entityManager.createQuery("Select u from User u where u.UserId =:id and u.Password =:password", User.class);
        query1.setParameter("id", user.UserId);
        query1.setParameter("password", user.LastName);
        

        try {
            User user1 = query1.getSingleResult();
            if (user1 != null) {
                user1.Password = user.Password;
                entityManager.getTransaction().begin();
                entityManager.persist(user1);
                entityManager.getTransaction().commit();
                res.setCode(1);
                res.setMessage("Password Changed");
                return res;
            }
            else
            {
                res.setCode(1);
                res.setMessage("Invalid Details");
                return res;
            }
        } catch (Exception e) {
            res.setCode(0);

            res.setMessage("Invalid Details");

            e.printStackTrace();
            return res;

        } finally {
            entityManager.close();
            // entityManagerFactory.close();
        }
        
    }

    public APIResponse forgotPassword(User user) {
     APIResponse res = new APIResponse();

        TypedQuery<User> query1 = entityManager.createQuery("Select u from User u where u.Email =:email", User.class);
        query1.setParameter("email", user.Email);

        try {
            User user1 = query1.getSingleResult();
            if (user1 != null) {
                Random rnd= new Random();
                int number = rnd.nextInt(999999);

                // this will convert any number sequence into 6 character.
                user1.Password= String.format("%06d", number);
                
                entityManager.getTransaction().begin();
                entityManager.persist(user1);
                entityManager.getTransaction().commit();
                res.setCode(1);
                res.setMessage("Password Changed");
                
                SendMail mail = new SendMail();
                String subject="Your New Password for YourAlly";
                String content ="Your New Password for YourAlly is " + user1.Password;
                
                mail.sendemail(user1.Email, subject, content);
                return res;
            } else {
                res.setCode(1);
                res.setMessage("Invalid Details");
                return res;
            }
        } catch (Exception e) {
            res.setCode(0);

            res.setMessage("Invalid Details");

            e.printStackTrace();
            return res;

        } finally {
            entityManager.close();
            // entityManagerFactory.close();
        }
    }
}
