package com.spring.appointmentManagement.service;


import com.spring.appointmentManagement.entity.Appointment;
import com.spring.appointmentManagement.helper.ExcelHelper;
import com.spring.appointmentManagement.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {

    @Autowired
    AppointmentRepository repository;

    public void save(MultipartFile file) {
        try {
            List<Appointment> appointments = ExcelHelper.excelToAppointments(file.getInputStream());
            repository.saveAll(appointments);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public List<Appointment> getAllAppointments() {
        return repository.findAll();
    }

    public ByteArrayInputStream load() {
        List<Appointment> appointments = repository.findAll();

        ByteArrayInputStream in = ExcelHelper.appointmentsToExcel(appointments);
        return in;
    }


}
