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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.io.Serializable;
import java.util.Date;
 
@Entity
public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer AppointmentId;
 
    
    public String AppointmentDate;
    public String Status;
    public Date CreatedDate;
    public String Problem;
    public String Description;

    @ManyToOne
    @JoinColumn(name="UserId")
    public User UserId;
   
    @ManyToOne
   @JoinColumn(name="helperId")
   public HelperDetail helperId;
    
    public Appointment() {
    }

    public Appointment(Integer AppointmentId, User user, HelperDetail helper, String AppointmentDate, String Status, Date CreatedDate) {
        this.AppointmentId = AppointmentId;
        this.UserId = user;
        this.helperId = helper;
        this.AppointmentDate = AppointmentDate;
        this.Status = Status;
        this.CreatedDate = CreatedDate;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getAppointmentId() {
        return AppointmentId;
    }

    public User getUserId() {
        return UserId;
    }

    public HelperDetail getHelperId() {
        return helperId;
    }

    public String getAppointmentDate() {
        return AppointmentDate;
    }

    public String getStatus() {
        return Status;
    }

    public Date getCreatedDate() {
        return CreatedDate;
    }

    public void setAppointmentId(Integer AppointmentId) {
        this.AppointmentId = AppointmentId;
    }

    public void setUserId(User UserId) {
        this.UserId = UserId;
    }

    public void setHelperId(HelperDetail helperId) {
        this.helperId = helperId;
    }

    public void setAppointmentDate(String AppointmentDate) {
        this.AppointmentDate = AppointmentDate;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public void setCreatedDate(Date CreatedDate) {
        this.CreatedDate = CreatedDate;
    }

    /**
     * @return the Problem
     */
    public String getProblem() {
        return Problem;
    }

    /**
     * @param Problem the Problem to set
     */
    public void setProblem(String Problem) {
        this.Problem = Problem;
    }

    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }
    
    
}
