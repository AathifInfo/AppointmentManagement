package com.spring.appointmentManagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public class DoctorDTO {
    private long doctorId;
    @NotBlank(message = "The doctor name is required.")
    private String doctorName;
    @NotEmpty(message = "The email is required")
    @Email
    private String doctorEmail;
    @NotEmpty(message = "The doctor contact number is required.")
    @Length(max = 10, min = 10, message = "Number should be 10 character")
    private String doctorContactNumber;

    public DoctorDTO() {
    }

    public DoctorDTO(long doctorId, String doctorName, String doctorEmail, String doctorContactNumber) {
        this.doctorId = doctorId;
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
        return "DoctorDTO{" +
                "doctorId=" + doctorId +
                ", doctorName='" + doctorName + '\'' +
                ", doctorEmail='" + doctorEmail + '\'' +
                ", doctorContactNumber='" + doctorContactNumber + '\'' +
                '}';
    }
}
