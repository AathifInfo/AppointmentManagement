package com.spring.appointmentManagement.controller;

import com.spring.appointmentManagement.dto.DoctorDTO;
import com.spring.appointmentManagement.entity.Doctor;
import com.spring.appointmentManagement.service.DoctorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/doctor")
public class DoctorController {

    private static final Logger logger = LoggerFactory.getLogger(DoctorController.class);

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/create")
    public ResponseEntity<DoctorDTO> createDoctor(@RequestBody DoctorDTO doctorDTO){
//        logger.info("Created Doctor with ID: {}", doctorSaveDTO.getDoctorId());
        return doctorService.addDoctor(doctorDTO);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Doctor>> getAllDoctors(@RequestParam(required = false) String type){
        return doctorService.getAllDoctor(type);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Doctor> getDoctorId(@PathVariable("id") long id){
        return doctorService.getDoctorById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable("id") long id, @RequestBody DoctorDTO doctorDTO){
        return doctorService.updateDoctor(id, doctorDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteDoctorByID(@PathVariable("id") long id){
        return doctorService.deleteDoctorByID(id);
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<HttpStatus> deleteAllDoctors(){
        return doctorService.deleteAllDoctors();
    }
}
