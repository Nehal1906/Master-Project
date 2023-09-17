/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.yourally.repository;

import com.project.yourally.entity.Resource;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;
 
public class ResourceRepository implements Serializable {

    public List<Resource> getAll() {
        List<Resource> list = null;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            TypedQuery<Resource> query1 = entityManager.createQuery("SELECT u FROM Resource u", Resource.class);

            list = query1.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            entityManager.close();
           // entityManagerFactory.close();
        }
        return list;
    }
}
