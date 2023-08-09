package com.spring.appointmentManagement.dto;

import java.util.Date;

public class AppointmentDTO {

    private long appointmentID;
    private String appointmentType;
    private Date date;
    private double amount;


    public AppointmentDTO() {
    }

    public AppointmentDTO(int appointmentID, String appointmentType, Date date, double amount) {
        this.appointmentID = appointmentID;
        this.appointmentType = appointmentType;
        this.date = date;
        this.amount = amount;
    }

    public long getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(long appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "AppointmentDTO{" +
                "appointmentID=" + appointmentID +
                ", appointmentType='" + appointmentType + '\'' +
                ", date='" + date + '\'' +
                ", amount=" + amount +
                '}';
    }

}
