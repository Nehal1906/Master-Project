/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.yourally.entity;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;
import jakarta.persistence.Table;
 
@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer UserId;
    public String FirstName; 
    public String LastName;
    public String Email;
    public String PhoneNumber;
    public String Address;
    public String Password;
    public Boolean IsAdmin;
    public Boolean IsSeeker;
    public Boolean IsHelper;
    public Date Dateofbirth;
    public Date CreatedDate;
    public Boolean IsDeleted;
    public String Gender;

    public User() {
    }

     public User(Integer userid) {
         UserId  = userid;
     }

    public User(Integer UserId,String FirstName, String LastName, String Email, String PhoneNumber, String Address, String Password, Boolean IsAdmin, Boolean IsSeeker, Boolean IsHelper, Date Dateofbirth, Date CreatedDate, Boolean IsDeleted, String Gender) {
        this.UserId=UserId;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.Address = Address;
        this.Password = Password;
        this.IsAdmin = IsAdmin;
        this.IsSeeker = IsSeeker;
        this.IsHelper = IsHelper;
        this.Dateofbirth = Dateofbirth;
        this.CreatedDate = CreatedDate;
        this.IsDeleted = IsDeleted;
        this.Gender = Gender;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return UserId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public String getPassword() {
        return Password;
    }

    public Boolean getIsAdmin() {
        return IsAdmin;
    }

    public Boolean getIsSeeker() {
        return IsSeeker;
    }

    public Boolean getIsHelper() {
        return IsHelper;
    }

    public Date getDateofbirth() {
        return Dateofbirth;
    }

    public Date getCreatedDate() {
        return CreatedDate;
    }

    public Boolean getIsDeleted() {
        return IsDeleted;
    }

    public String getGender() {
        return Gender;
    }

    public void setId(Integer id) {
        this.UserId = id;
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setIsAdmin(Boolean IsAdmin) {
        this.IsAdmin = IsAdmin;
    }

    public void setIsSeeker(Boolean IsSeeker) {
        this.IsSeeker = IsSeeker;
    }

    public void setIsHelper(Boolean IsHelper) {
        this.IsHelper = IsHelper;
    }

    public void setDateofbirth(Date Dateofbirth) {
        this.Dateofbirth = Dateofbirth;
    }

    public void setCreatedDate(Date CreatedDate) {
        this.CreatedDate = CreatedDate;
    }

    public void setIsDeleted(Boolean IsDeleted) {
        this.IsDeleted = IsDeleted;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + UserId + ", firstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email + ", PhoneNumber=" + PhoneNumber + ", Address=" + Address + ", Password=" + Password + ", IsAdmin=" + IsAdmin + ", IsSeeker=" + IsSeeker + ", IsHelper=" + IsHelper + ", Dateofbirth=" + Dateofbirth + ", CreatedDate=" + CreatedDate + ", IsDeleted=" + IsDeleted + ", Gender=" + Gender + '}';
    }

    
     
 
    
}
