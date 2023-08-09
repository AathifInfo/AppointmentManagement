package com.spring.appointmentManagement.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Appointment_Table")
public class Appointment {

    @Id
    @Column(name = "Appointment_ID", length = 20)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long appointmentID;

    @Column(name = "Appointment_Type", length = 50)
    private String appointmentType;

    @Column(name = "Appointment_Date", length = 30)
    private Date date;

    @Column(name = "Appointment_Amount")
    private double amount;

    public Appointment() {
    }

    public Appointment(String appointmentType, Date date, double amount) {
        this.appointmentType = appointmentType;
        this.date = date;
        this.amount = amount;
    }

    public long getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
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
        return "Appointment{" +
                "AppointmentID=" + appointmentID +
                ", AppointmentType='" + appointmentType + '\'' +
                ", Date='" + date + '\'' +
                ", Amount=" + amount +
                '}';
    }

}
