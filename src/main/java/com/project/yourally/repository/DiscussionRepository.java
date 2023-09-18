/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.yourally.repository;

import com.project.yourally.entity.Appointment;
import com.project.yourally.entity.Board;
import com.project.yourally.entity.DiscussionForum;
import com.project.yourally.entity.Message;
import com.project.yourally.utils.APIResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
 
/*
    this is discussion forum repository 
    get and create a discussion forum,
    save message to database
    functionality done
*/
public class DiscussionRepository implements Serializable {

    /*
        getOrCreateDiscussionForum method create a discussion forum or get data 
        if the discussion forum already created
    */
    public Board getOrCreateDiscussionForum(Appointment app) {

        Board board = new Board();

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<DiscussionForum> query1 = entityManager.createQuery("select u from DiscussionForum u where u.AppointmentId =:id", DiscussionForum.class);
        query1.setParameter("id", app);

        DiscussionForum dis = null;

        try {
            dis = query1.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (dis == null) {
            Appointment ap1 = null;
            TypedQuery<Appointment> query2 = entityManager.createQuery("select a from Appointment a where a.AppointmentId =:id", Appointment.class);
            query2.setParameter("id", app.AppointmentId);
            ap1 = query2.getSingleResult();

            if (ap1 != null) {
                dis = new DiscussionForum();
                dis.AppointmentId = ap1;
                dis.USerId = ap1.UserId;
                dis.HelperId = ap1.helperId;
                dis.CreatedDate = new Date();
                dis.Description = ap1.UserId.FirstName + " - " + ap1.helperId.getUserId().FirstName + " Discussion Forum";

                entityManager.getTransaction().begin();
                entityManager.persist(dis);
                entityManager.getTransaction().commit();

            }

        }

        TypedQuery<Message> query3 = entityManager.createQuery("select u from Message u where u.DiscussionForumId=:id", Message.class);
        query3.setParameter("id", dis);

        List<Message> messagelist = query3.getResultList();

        board.setDis(dis);
        board.setMessagelist(messagelist);

        return board;
    }

    /*
        saveMessage method save the message in the database
    */
    public APIResponse saveMessage(Message message) {
        APIResponse res = new APIResponse();

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        message.CreatedDate = new Date();
        
        entityManager.getTransaction().begin();
        entityManager.persist(message);
        entityManager.getTransaction().commit();

        return res;
    }
}
