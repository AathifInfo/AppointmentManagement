package com.spring.appointmentManagement.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "doctor_table")
public class Doctor {

    @Id
    @Column(name = "doctor_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long doctorId;

    @Column(name = "doctor_name")
//    @NotBlank(message = "The doctor name is required.")
    private String doctorName;

    @Column(name = "doctor_email")
//    @NotEmpty(message = "The email is required")
//    @Email
    private String doctorEmail;

    @Column(name = "doctor_contact")
//    @NotEmpty(message = "The doctor contact number is required.")
    private String doctorContactNumber;

    public Doctor() {
    }

//    public Doctor(long doctorId, String doctorName, String doctorEmail, String doctorContactNumber) {
//        this.doctorId = doctorId;
//        this.doctorName = doctorName;
//        this.doctorEmail = doctorEmail;
//        this.doctorContactNumber = doctorContactNumber;
//    }

    public Doctor(String doctorName, String doctorEmail, String doctorContactNumber) {
        this.doctorName = doctorName;
        this.doctorEmail = doctorEmail;
        this.doctorContactNumber = doctorContactNumber;
    }

    public long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public String getDoctorContactNumber() {
        return doctorContactNumber;
    }

    public void setDoctorContactNumber(String doctorContactNumber) {
        this.doctorContactNumber = doctorContactNumber;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", doctorName='" + doctorName + '\'' +
                ", doctorEmail='" + doctorEmail + '\'' +
                ", doctorContactNumber='" + doctorContactNumber + '\'' +
                '}';
    }

}
