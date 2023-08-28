/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jharna
 */
@Entity
public class HelperDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer HelperDetailId;
    public Integer UserId;
    public String Specialization;
    public String Description;
    public Date CreateDate;
    public boolean IsDeleted;
    public String LicenceNumber;

    public HelperDetail() {
    }

    public HelperDetail(Integer HelperDetailId, Integer UserId, String Specialization, String Description, Date CreateDate, boolean IsDeleted, String LicenceNumber) {
        this.HelperDetailId = HelperDetailId;
        this.UserId = UserId;
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

    public Integer getUserId() {
        return UserId;
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

    public void setUserId(Integer UserId) {
        this.UserId = UserId;
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
