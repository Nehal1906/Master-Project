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
public class Appointment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer AppointmentId;
    public Integer UserId;
    public Integer helperId;
    public Date AppointmentDate;
    public String Status;
    public Date CreatedDate;

    public Appointment() {
    }

    public Appointment(Integer AppointmentId, Integer UserId, Integer helperId, Date AppointmentDate, String Status, Date CreatedDate) {
        this.AppointmentId = AppointmentId;
        this.UserId = UserId;
        this.helperId = helperId;
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

    public Integer getUserId() {
        return UserId;
    }

    public Integer getHelperId() {
        return helperId;
    }

    public Date getAppointmentDate() {
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

    public void setUserId(Integer UserId) {
        this.UserId = UserId;
    }

    public void setHelperId(Integer helperId) {
        this.helperId = helperId;
    }

    public void setAppointmentDate(Date AppointmentDate) {
        this.AppointmentDate = AppointmentDate;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public void setCreatedDate(Date CreatedDate) {
        this.CreatedDate = CreatedDate;
    }
    
    
}
