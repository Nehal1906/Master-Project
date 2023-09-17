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
    public Integer HelperDetailId;
//    public Integer UserId;
    public String Specialization;
    public String Description;
    public Date CreateDate;
    public boolean IsDeleted;
    public String LicenceNumber;
    
    @OneToOne
    @JoinColumn(name="UserId")
    User user;

    public HelperDetail() {
    }

    public HelperDetail(Integer id)
    {
        HelperDetailId= id;
    }
    public HelperDetail(Integer HelperDetailId, User user, String Specialization, String Description, Date CreateDate, boolean IsDeleted, String LicenceNumber) {
        this.HelperDetailId = HelperDetailId;
        this.user = user;
        this.Specialization = Specialization;
        this.Description = Description;
        this.CreateDate = CreateDate;
        this.IsDeleted = IsDeleted;
        this.LicenceNumber = LicenceNumber;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getHelperDetailId() {
        return HelperDetailId;
    }

    public User getUserId() {
        return user;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public String getDescription() {
        return Description;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public boolean isIsDeleted() {
        return IsDeleted;
    }

    public String getLicenceNumber() {
        return LicenceNumber;
    }



    public void setHelperDetailId(Integer HelperDetailId) {
        this.HelperDetailId = HelperDetailId;
    }

    public void setUserId(User user) {
        this.user = user;
    }

    public void setSpecialization(String Specialization) {
        this.Specialization = Specialization;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setCreateDate(Date CreateDate) {
        this.CreateDate = CreateDate;
    }

    public void setIsDeleted(boolean IsDeleted) {
        this.IsDeleted = IsDeleted;
    }

    public void setLicenceNumber(String LicenceNumber) {
        this.LicenceNumber = LicenceNumber;
    }

 
    
    
}
