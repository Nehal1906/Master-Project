/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.yourally.repository;

import com.project.yourally.entity.Appointment;
import com.project.yourally.entity.HelperDetail;
import com.project.yourally.entity.User;
import com.project.yourally.utils.APIResponse;
import com.project.yourally.utils.SendMail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
    this is appointment repository 
    create appointment, update status
    get helper and seeker appointment 
    functionality done
*/
public class AppointmentRepository implements Serializable {

    /*
        update status by time method set the appointment status 
    */
    public void updateStatusByTime(Appointment app) {
        Date current = new Date();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Date appdate;
        try {
            appdate = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(app.AppointmentDate);
            if (appdate.after(current)) {
                app.Status = "Scheduled";
            } else {

                app.Status = "Completed";
            }

//            entityManager.getTransaction().begin();
//            entityManager.persist(app);
//            entityManager.getTransaction().commit();
        } catch (ParseException ex) {
            Logger.getLogger(AppointmentRepository.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

     /*
        getUserAppointment method returns the list of logged in user appointments. 
    */
    public List<Appointment> getUserAppointment(User user) {
        List<Appointment> list = null;
        List<Appointment> updatedlist = new ArrayList<>();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            TypedQuery<Appointment> query1 = entityManager.createQuery("SELECT u FROM Appointment u WHERE u.UserId = :userid", Appointment.class);
            query1.setParameter("userid", user);

            list = query1.getResultList();
            for (Appointment app : list) {
                if (!app.Status.equals("Cancelled")) {
                    updateStatusByTime(app);
                    entityManager.getTransaction().begin();
                    entityManager.persist(app);
                    entityManager.getTransaction().commit();
                }
                updatedlist.add(app);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

     /*
        getHelperrAppointment method returns the list of logged in helper appointments. 
    */
    public List<Appointment> getHelperrAppointment(HelperDetail helperId) {
        List<Appointment> list = null;
        List<Appointment> updatedlist = new ArrayList<>();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            TypedQuery<Appointment> query1 = entityManager.createQuery("SELECT u FROM Appointment u WHERE u.helperId = :helperId", Appointment.class);
            query1.setParameter("helperId", helperId);

            list = query1.getResultList();

            for (Appointment app : list) {
                if (!app.Status.equals("Cancelled")) {
                    updateStatusByTime(app);
                    entityManager.getTransaction().begin();
                    entityManager.persist(app);
                    entityManager.getTransaction().commit();
                }
                updatedlist.add(app);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updatedlist;
    }

     /*
        createAppointment method use to add new data in databas eand retunrn string message 
    */
    public APIResponse createAppointment(Appointment app) {
        APIResponse res = new APIResponse();

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            app.CreatedDate = new Date();

            Date appdate = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse(app.AppointmentDate);
            System.out.println("current :" + app.CreatedDate.toString());
            System.out.println("Book " + appdate.toString());

            if (appdate.after(app.CreatedDate)) {
                app.Status = "Scheduled";
            } else {

                app.Status = "Completed";
            }

            entityManager.getTransaction().begin();
            entityManager.persist(app);
            entityManager.getTransaction().commit();
            res.setCode(1);
            res.setMessage("Booking Success");

            TypedQuery<User> query1 = entityManager.createQuery("select a from User a where a.UserId =:id", User.class);
            query1.setParameter("id", app.UserId.UserId);

            User ap1 = query1.getSingleResult();

            TypedQuery<HelperDetail> query2 = entityManager.createQuery("select a from HelperDetail a where a.HelperDetailId =:id", HelperDetail.class);
            query2.setParameter("id", app.helperId.HelperDetailId);

            HelperDetail hlp1 = query2.getSingleResult();

            String subject = "Your Appointment Booked";
            String contentuser = "Hi,<br/>Your Appointment for " + app.Problem + " has been booked with " + hlp1.getUserId().FirstName + ", in YourAlly on " + app.AppointmentDate;
            String contenthelper = "Hi,<br/> " + ap1.FirstName + " has been booked appointment with you for " + app.Problem + ", in YourAlly on " + app.AppointmentDate;
            SendMail mail = new SendMail();

            mail.sendemail(ap1.Email, subject, contentuser);
            mail.sendemail(hlp1.getUserId().Email, subject, contenthelper);
        } catch (Exception e) {
            e.printStackTrace();
            res.setCode(0);
            res.setMessage("Booking Failed");
        }

        return res;
    }

     /*
        closeAppointment method change the appointment status
    */
    public boolean closeAppointment(Appointment app) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Appointment ap1 = null;
        try {
            TypedQuery<Appointment> query1 = entityManager.createQuery("select u from Appointment u where u.AppointmentId =:id", Appointment.class);
            query1.setParameter("id", app.AppointmentId);

            ap1 = query1.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (ap1 != null) {

            ap1.Status = "Cancelled";
            entityManager.getTransaction().begin();
            entityManager.persist(ap1);
            entityManager.getTransaction().commit();
        }
        return true;
    }
}
