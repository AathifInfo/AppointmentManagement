package com.spring.appointmentManagement.service;

import com.spring.appointmentManagement.dto.AppointmentDTO;
import com.spring.appointmentManagement.entity.Appointment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AppointmentService {
    ResponseEntity<AppointmentDTO> addAppointment(AppointmentDTO appointmentDTO);


    ResponseEntity<List<Appointment>> getAllAppointment(String type);

    ResponseEntity<Appointment> getAppointmentById(long id);

    ResponseEntity<Appointment> updateAppointment(long id, AppointmentDTO appointmentDTO);

    ResponseEntity<HttpStatus> deleteAppointmentById(long id);

    ResponseEntity<HttpStatus> deleteAllAppointments();
}
