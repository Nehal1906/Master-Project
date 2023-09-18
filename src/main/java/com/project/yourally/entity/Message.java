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
import java.util.Date;
 
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer MessageId; //interger variable for message id
    
    @ManyToOne
    @JoinColumn(name = "UserId")
    public User UserId;
    
    
    @ManyToOne
    @JoinColumn(name="DiscussionForumId")
    public DiscussionForum DiscussionForumId;
    
    public String Description; //string variable for description
    public Date CreatedDate;//date variable for created date
    public boolean IsDeleted ; //boolean variable for is deleted

}
