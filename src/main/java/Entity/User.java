/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 *
 * @author jharn
 */
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    public String firstName; 
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

    public User(Integer id, String firstName, String LastName, String Email, String PhoneNumber, String Address, String Password, Boolean IsAdmin, Boolean IsSeeker, Boolean IsHelper, Date Dateofbirth, Date CreatedDate, Boolean IsDeleted, String Gender) {
        this.id = id;
        this.firstName = firstName;
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
        return id;
    }

    public String getFirstName() {
        return firstName;
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
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    
     
 
    
}
