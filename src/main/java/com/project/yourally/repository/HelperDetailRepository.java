/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.yourally.repository;

import com.project.yourally.entity.HelperDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Admin
 */
public class HelperDetailRepository implements Serializable {

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
}
