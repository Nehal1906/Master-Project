/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.yourally.repository;

import com.project.yourally.entity.Appointment;
import com.project.yourally.entity.HelperDetail;
import com.project.yourally.entity.User;
import com.project.yourally.utils.APIResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class AppointmentRepository implements Serializable {
    
    public List<Appointment> getUserAppointment(User user) {
        List<Appointment> list = null;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        try {
            TypedQuery<Appointment> query1 = entityManager.createQuery("SELECT u FROM Appointment u WHERE u.UserId = :userid", Appointment.class);
            query1.setParameter("userid", user);
            
            list = query1.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public APIResponse createAppointment(Appointment app) {
        APIResponse res = new APIResponse();
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        try {
            app.CreatedDate = new Date();
            app.Status="Pending";
            
              entityManager.getTransaction().begin();
            entityManager.persist(app);
            entityManager.getTransaction().commit();
            res.setCode(1);
            res.setMessage("Booking Success");
        } catch (Exception e) {
            e.printStackTrace();
            res.setCode(0);
            res.setMessage("Booking Failed");
        }
        
        return res;
    }
}
