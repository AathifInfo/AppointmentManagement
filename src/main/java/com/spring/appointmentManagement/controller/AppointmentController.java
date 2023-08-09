package com.spring.appointmentManagement.controller;


import com.spring.appointmentManagement.dto.AppointmentDTO;
import com.spring.appointmentManagement.entity.Appointment;
import com.spring.appointmentManagement.service.AppointmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/appointment")
@Slf4j//base URL
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping(path = "/create")  //end point
    public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody AppointmentDTO appointmentDTO){
        return appointmentService.addAppointment(appointmentDTO);

    }

    @GetMapping(path = "/get")
    public ResponseEntity<List<Appointment>> getAppointment(@RequestParam(required = false) String type) {
        return appointmentService.getAllAppointment(type);

    }

    @GetMapping(path = "/get/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable("id") long id) {
        return appointmentService.getAppointmentById(id);

    }

    @PutMapping(path = "/update/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable("id") long id, @RequestBody AppointmentDTO appointmentDTO){
        return appointmentService.updateAppointment(id, appointmentDTO);
    }


    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<HttpStatus> deleteAppointmentById(@PathVariable("id") long id){
        return appointmentService.deleteAppointmentById(id);
    }


    @DeleteMapping(path = "/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllAppointments(){
        return appointmentService.deleteAllAppointments();
    }

}
