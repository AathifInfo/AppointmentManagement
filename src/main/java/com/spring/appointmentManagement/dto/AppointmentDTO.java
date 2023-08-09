package com.spring.appointmentManagement.dto;

import jakarta.validation.constraints.*;
import org.checkerframework.checker.optional.qual.Present;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class AppointmentDTO {

    private long appointmentID;
    @NotBlank(message = "The appointment type is required")
    @Size(min = 3, max = 20, message = "The appointment type must be from 3 to 20 characters")
    private String appointmentType;

    @NotNull(message = "The date is required")
    @Future(message = "Appointment date must be in the future")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @NotNull(message = "The amount is required")
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
