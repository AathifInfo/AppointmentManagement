package com.spring.appointmentManagement.serviceIMPL;


import com.spring.appointmentManagement.dto.DoctorDTO;
import com.spring.appointmentManagement.entity.Doctor;
import com.spring.appointmentManagement.repository.DoctorRepository;
import com.spring.appointmentManagement.service.DoctorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceIMPL implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepo;

    private static final Logger logger = LoggerFactory.getLogger(DoctorServiceIMPL.class);

    @Override
    public ResponseEntity<DoctorDTO> addDoctor(DoctorDTO doctorDTO) {
        try {
            Doctor doctor = doctorRepo
                    .save(new Doctor(
                            doctorDTO.getDoctorName(),
                            doctorDTO.getDoctorEmail(),
                            doctorDTO.getDoctorContactNumber()
                    ));
            logger.info("Created Doctor with ID: {}", doctor.getDoctorId());
            return new ResponseEntity<>(doctorDTO, HttpStatus.CREATED);
        } catch (Exception e){
            logger.error("Error while creating Doctor: {}", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Doctor>> getAllDoctor(String name) {
        try {
            List<Doctor> doctorList = new ArrayList<>();

            if(name == null){
                doctorRepo.findAll().forEach(doctorList::add);
            }else {
                doctorRepo.findByDoctorName(name).forEach(doctorList::add);
            }
            if(doctorList.isEmpty()) {
                logger.info("No doctors found.");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            logger.info("Returning {} doctors.", doctorList.size());
            return new ResponseEntity<>(doctorList, HttpStatus.OK);
        }catch (Exception e){
            logger.error("Error occurred while fetching doctors: {}", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Doctor> getDoctorById(long id) {
        try {
            Optional<Doctor> doctorData = doctorRepo.findById(id);

            if (doctorData.isPresent()){
                logger.info("Returning doctor id: {}", doctorData.get().getDoctorId());
                return new ResponseEntity<>(doctorData.get(), HttpStatus.OK);
            }else {
                logger.info("Doctor not found.");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            logger.error("Error occurred while fetching doctor: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Doctor> updateDoctor(long id, DoctorDTO doctorDTO) {

        try {
            Optional<Doctor> doctorData = doctorRepo.findById(id);

            if(doctorData.isPresent()){
                Doctor doctor =doctorData.get();
                doctor.setDoctorName(doctorDTO.getDoctorName());
                doctor.setDoctorEmail(doctorDTO.getDoctorEmail());
                doctor.setDoctorContactNumber(doctorDTO.getDoctorContactNumber());

                logger.info("Updated doctor id: {} ", doctor.getDoctorId());
                return new ResponseEntity<>(doctorRepo.save(doctor), HttpStatus.OK);
            }else {
                logger.info("Doctor not found.");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e){
            logger.error("Error occurred while updating doctor: {}", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Override
    public ResponseEntity<HttpStatus> deleteDoctorByID(long id) {
        try {
            doctorRepo.deleteById(id);
            logger.info("Doctor id {} is deleted", id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            logger.error("Error occurred while deleting doctor: {}", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> deleteAllDoctors() {

        try {
            doctorRepo.deleteAll();
            logger.info("All Doctors are deleted");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            logger.error("Error occurred while deleting doctors: {}", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
