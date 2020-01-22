/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Sensors.Sensor;
import Business.UserAccount.UserAccount;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author Akshay
 */
public abstract class WorkRequest {

    //private Sensor sensor;
    private String Work_id;
    private static int count = 1;
    
    private String message;
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    private Long zipcode;
    //private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    
    public WorkRequest(){
       requestDate = new Date();
       Work_id = "Work Request "+count++;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    public Long getZipcode() {
        return zipcode;
    }

    public void setZipcode(Long zipcode) {
        this.zipcode = zipcode;
    }
    
    @Override
    public String toString() {
        return Work_id;
    }

//    public Sensor getSensor() {
//        return sensor;
//    }
//
//    public void setSensor(Sensor sensor) {
//        this.sensor = sensor;
//    }
    
}
