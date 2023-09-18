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
    public Integer UserId; //integer variable for user id
    public String FirstName; //string variable for first name
    public String LastName; //string variable for last name
    public String Email; //string variable for email
    public String PhoneNumber; //string variable for phone number
    public String Address; //string variable for address
    public String Password; //string variable for password
    public Boolean IsAdmin; //boolean variable for isadmin
    public Boolean IsSeeker; //boolean variable for isseeker
    public Boolean IsHelper; //boolean variable for ishelper
    public Date Dateofbirth; //date variable for date of birth
    public Date CreatedDate; //date variable for created date
    public Boolean IsDeleted; //boolean variable for is deleted
    public String Gender; //string variable for gender

    //constructor of user without parameter
    public User() {
    }

    //constructor of user with user id parameter 
     public User(Integer userid) {
         UserId  = userid;
     }

    //constructor of user with parameters 
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

    //getter and setter for id
    public Integer getId() {
        return UserId;
    }
    public void setId(Integer id) {
        this.UserId = id;
    }

    //getter and setter for firstname
    public String getFirstName() {
        return FirstName;
    } 
    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    //getter and setter for lastname
    public String getLastName() {
        return LastName;
    }
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    //getter and setter for email
    public String getEmail() {
        return Email;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }

    //getter and setter for phone number
    public String getPhoneNumber() {
        return PhoneNumber;
    }
    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    //getter and setter for address
    public String getAddress() {
        return Address;
    }
    public void setAddress(String Address) {
        this.Address = Address;
    }

    //getter and setter for password
    public String getPassword() {
        return Password;
    }
    public void setPassword(String Password) {
        this.Password = Password;
    }

    //getter and setter for is admin
    public Boolean getIsAdmin() {
        return IsAdmin;
    }
    public void setIsAdmin(Boolean IsAdmin) {
        this.IsAdmin = IsAdmin;
    }

    //getter and setter for is seeker
    public Boolean getIsSeeker() {
        return IsSeeker;
    }
    public void setIsSeeker(Boolean IsSeeker) {
        this.IsSeeker = IsSeeker;
    }

    //getter and setter for is helper
    public Boolean getIsHelper() {
        return IsHelper;
    }
    public void setIsHelper(Boolean IsHelper) {
        this.IsHelper = IsHelper;
    }

    //getter and setter for date of birth
    public Date getDateofbirth() {
        return Dateofbirth;
    }
    public void setDateofbirth(Date Dateofbirth) {
        this.Dateofbirth = Dateofbirth;
    }

    //getter and setter for created date
    public Date getCreatedDate() {
        return CreatedDate;
    }
    public void setCreatedDate(Date CreatedDate) {
        this.CreatedDate = CreatedDate;
    }

    //getter and setter for is deleted
    public Boolean getIsDeleted() {
        return IsDeleted;
    }
    public void setIsDeleted(Boolean IsDeleted) {
        this.IsDeleted = IsDeleted;
    }

    //getter and setter for gender
    public String getGender() {
        return Gender;
    }
    public void setGender(String Gender) {
        this.Gender = Gender;
    }
 
    @Override
    public String toString() {
        return "User{" + "id=" + UserId + ", firstName=" + FirstName + ", LastName=" + LastName + ", Email=" + Email + ", PhoneNumber=" + PhoneNumber + ", Address=" + Address + ", Password=" + Password + ", IsAdmin=" + IsAdmin + ", IsSeeker=" + IsSeeker + ", IsHelper=" + IsHelper + ", Dateofbirth=" + Dateofbirth + ", CreatedDate=" + CreatedDate + ", IsDeleted=" + IsDeleted + ", Gender=" + Gender + '}';
    } 
    
}
