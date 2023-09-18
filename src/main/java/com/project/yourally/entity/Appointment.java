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
    public Integer AppointmentId; //integer variable of appointment id
 
    
    public String AppointmentDate;// string variable of appointment date
    public String Status;//string variable of status
    public Date CreatedDate;//date variable of created date
    public String Problem;//string varible of problem
    public String Description;//string variable of description

    @ManyToOne
    @JoinColumn(name="UserId")
    public User UserId; //userid variable from user class
   
    @ManyToOne
   @JoinColumn(name="helperId")
   public HelperDetail helperId; //helperid variable from helpwe class
    
    //constructor of appointment without pass parameter
    public Appointment() {
    }

    //constructor of appointment with parameter
    public Appointment(Integer AppointmentId, User user, HelperDetail helper, String AppointmentDate, String Status, Date CreatedDate) {
        this.AppointmentId = AppointmentId;
        this.UserId = user;
        this.helperId = helper;
        this.AppointmentDate = AppointmentDate;
        this.Status = Status;
        this.CreatedDate = CreatedDate;
    }

    //get method for serialVersionUID
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    //get method for appointment id
    public Integer getAppointmentId() {
        return AppointmentId;
    }

    //get method for user id
    public User getUserId() {
        return UserId;
    }

    //get method for helper id
    public HelperDetail getHelperId() {
        return helperId;
    }

    //get method for appointment date
    public String getAppointmentDate() {
        return AppointmentDate;
    }

    //get method for status
    public String getStatus() {
        return Status;
    }

    //get method for created date
    public Date getCreatedDate() {
        return CreatedDate;
    }

    //set method for appointment id
    public void setAppointmentId(Integer AppointmentId) {
        this.AppointmentId = AppointmentId;
    }

    //set method for user id
    public void setUserId(User UserId) {
        this.UserId = UserId;
    }

    //set method for helper id
    public void setHelperId(HelperDetail helperId) {
        this.helperId = helperId;
    }

    //set method for appointmentdate
    public void setAppointmentDate(String AppointmentDate) {
        this.AppointmentDate = AppointmentDate;
    }

    //set method for status
    public void setStatus(String Status) {
        this.Status = Status;
    }

    //set method for created date
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
