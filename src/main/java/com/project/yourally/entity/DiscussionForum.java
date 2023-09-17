/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.yourally.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;
 
@Entity
public class DiscussionForum implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer DiscussionForumId;

    @ManyToOne
    @JoinColumn(name = "AppointmentId")
    public Appointment AppointmentId;

    @ManyToOne
    @JoinColumn(name = "UserId")
    public User USerId;

    @ManyToOne
    @JoinColumn(name = "helperId")
    public HelperDetail HelperId;

    public String Description;
    public Date CreatedDate;

    
    public DiscussionForum()
    {
        
    }
    
    public DiscussionForum(Integer id)
    {
        DiscussionForumId= id;
    }
}
