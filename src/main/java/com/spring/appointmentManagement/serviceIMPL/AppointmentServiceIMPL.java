package com.spring.appointmentManagement.serviceIMPL;

import com.spring.appointmentManagement.dto.AppointmentDTO;
import com.spring.appointmentManagement.entity.Appointment;
import com.spring.appointmentManagement.repository.AppointmentRepository;
import com.spring.appointmentManagement.service.AppointmentService;
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
public class AppointmentServiceIMPL implements AppointmentService {


    private static final Logger logger = LoggerFactory.getLogger(AppointmentServiceIMPL.class);

    @Autowired
    AppointmentRepository appointmentRepository;

    @Override
    public ResponseEntity<AppointmentDTO> addAppointment(AppointmentDTO appointmentDTO) {
        try {
            Appointment appointment = new Appointment(
                    appointmentDTO.getAppointmentType(),
                    appointmentDTO.getDate(),
                    appointmentDTO.getAmount()
            );
            appointmentRepository.save(appointment);
            logger.info("Created Appointment with appointment id: {} ", appointment.getAppointmentID());
            return  new ResponseEntity<>(appointmentDTO, HttpStatus.CREATED);
        } catch (Exception e){
            logger.error("Error while creating the appointment: {}", e.getMessage());
            return  new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Appointment>> getAllAppointment(String type) {
        try {
            List<Appointment> appointmentList = new ArrayList<>();

            if(type == null){
                appointmentRepository.findAll().forEach(appointmentList::add);
            }else {
                appointmentRepository.findByAppointmentType(type).forEach(appointmentList::add);
            }

            if(appointmentList.isEmpty()){
                logger.info("No Appointment found");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            logger.info("Returning {} appointments.", appointmentList.size());
            return new ResponseEntity<>(appointmentList, HttpStatus.OK);

        } catch(Exception e){
            logger.error("Error occurred while fetching appointments: {}", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Appointment> getAppointmentById(long id) {
        try {
            Optional<Appointment> appointmentData = appointmentRepository.findById(id);

            if(appointmentData.isPresent()){
                logger.info("Returning appointment with id : {}", appointmentData.get().getAppointmentID());
                return new ResponseEntity<>(appointmentData.get(), HttpStatus.OK);
            }else {
                logger.info("Appointment not found");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

        } catch (Exception e){
            logger.error("Error occurred while fetching appointment: {}", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Appointment> updateAppointment(long id, AppointmentDTO appointmentDTO) {
        try {

            Optional<Appointment> appointmentData = appointmentRepository.findById(id);

            if (appointmentData.isPresent()){
                Appointment appointment = appointmentData.get();
                appointment.setAppointmentType(appointmentDTO.getAppointmentType());
                appointment.setDate(appointmentDTO.getDate());
                appointment.setAmount(appointmentDTO.getAmount());

                logger.info("Update appointment id: {}", appointment.getAppointmentID());
                return new ResponseEntity<>(appointmentRepository.save(appointment), HttpStatus.OK);

            }else {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
        } catch (Exception e){
            logger.error("Error occurred while updating appointment: {}", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> deleteAppointmentById(long id) {
        try {
            appointmentRepository.deleteById(id);
            logger.info("Appointment id {} is deleted ", id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            logger.error("Error occurred while deleting appointment: {}", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> deleteAllAppointments() {
        try {
            appointmentRepository.deleteAll();
            logger.info("All appointments are deleted ");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            logger.error("Error occurred while deleting appointment: {}", e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
