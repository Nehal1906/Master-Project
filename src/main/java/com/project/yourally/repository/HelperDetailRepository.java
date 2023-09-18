/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.yourally.repository;

import com.project.yourally.entity.HelperDetail;
import com.project.yourally.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

/*
    this is helper detail repository 
    get all helpers and
    get helper by user id
    functionality done
*/
public class HelperDetailRepository implements Serializable {

    /*
        getAllHelpers method return the list of helpers
    */
    public List<HelperDetail> getAllHelpers() {
        List<HelperDetail> list = null;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            TypedQuery<HelperDetail> query1 = entityManager.createQuery("SELECT u FROM HelperDetail u", HelperDetail.class);

            list = query1.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

     /*
        getAllHelpers method return the helper detail using user id
    */
    public HelperDetail getHelper(User user) {
        HelperDetail helper = null;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            TypedQuery<HelperDetail> query1 = entityManager.createQuery("SELECT u FROM HelperDetail u where u.user =:user", HelperDetail.class);
            query1.setParameter("user", user);

            helper = query1.getSingleResult();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return helper;
    }
}
