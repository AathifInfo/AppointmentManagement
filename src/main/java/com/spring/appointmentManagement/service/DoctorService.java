package com.spring.appointmentManagement.service;

import com.spring.appointmentManagement.dto.DoctorDTO;
import com.spring.appointmentManagement.entity.Doctor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DoctorService {

    ResponseEntity<DoctorDTO> addDoctor(DoctorDTO doctorSaveDTO);

    ResponseEntity<List<Doctor>> getAllDoctor(String type);

    ResponseEntity<Doctor> getDoctorById(long id);

    ResponseEntity<Doctor> updateDoctor(long id, DoctorDTO doctorSaveDTO);

    ResponseEntity<HttpStatus> deleteDoctorByID(long id);

    ResponseEntity<HttpStatus> deleteAllDoctors();

}
