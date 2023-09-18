/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.yourally.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
 
@Entity
public class HelperDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer HelperDetailId; //integer variable of helper detail id
//    public Integer UserId;
    public String Specialization;//string variable of specialization
    public String Description; //string variable of description
    public Date CreateDate;//dat variable of created date
    public boolean IsDeleted; //boolean variable of is deleted
    public String LicenceNumber; //string variable of licence number
    
    @OneToOne
    @JoinColumn(name="UserId")
    User user;

    //constructor of helper detail without parameter
    public HelperDetail() {
    }

    //constructor of helper detail with id parameter
    public HelperDetail(Integer id)
    {
        HelperDetailId= id;
    }
    
    //constructor of helper detail with parameters
    public HelperDetail(Integer HelperDetailId, User user, String Specialization, String Description, Date CreateDate, boolean IsDeleted, String LicenceNumber) {
        this.HelperDetailId = HelperDetailId;
        this.user = user;
        this.Specialization = Specialization;
        this.Description = Description;
        this.CreateDate = CreateDate;
        this.IsDeleted = IsDeleted;
        this.LicenceNumber = LicenceNumber;
    }

    //get method
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    //getter and setter for helper detail id
    public Integer getHelperDetailId() {
        return HelperDetailId;
    }
    public void setHelperDetailId(Integer HelperDetailId) {
        this.HelperDetailId = HelperDetailId;
    }

    //getter and setter for user id
    public User getUserId() {
        return user;
    }
    public void setUserId(User user) {
        this.user = user;
    }

    //getter and setter for specialization
    public String getSpecialization() {
        return Specialization;
    }
    public void setSpecialization(String Specialization) {
        this.Specialization = Specialization;
    }

    //getter and setter for description
    public String getDescription() {
        return Description;
    }
    public void setDescription(String Description) {
        this.Description = Description;
    }

    //getter and setter for created date
    public Date getCreateDate() {
        return CreateDate;
    }
    public void setCreateDate(Date CreateDate) {
        this.CreateDate = CreateDate;
    }

    //getter and setter for is deleted
    public boolean isIsDeleted() {
        return IsDeleted;
    }
    public void setIsDeleted(boolean IsDeleted) {
        this.IsDeleted = IsDeleted;
    }

    //getter and setter for licence number
    public String getLicenceNumber() {
        return LicenceNumber;
    }
    public void setLicenceNumber(String LicenceNumber) {
        this.LicenceNumber = LicenceNumber;
    } 
}
