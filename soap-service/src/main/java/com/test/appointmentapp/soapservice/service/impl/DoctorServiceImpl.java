package com.test.appointmentapp.soapservice.service.impl;

import com.test.appointmentapp.soapservice.entity.Doctor;
import com.test.appointmentapp.soapservice.exception.IdException;
import com.test.appointmentapp.soapservice.repository.DoctorRepository;
import com.test.appointmentapp.soapservice.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("doctorService")
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository repository;

    public Doctor getDoctorEntityById(Long id) {
        Optional<Doctor> patient = repository.findById(id.toString());
        return patient.orElseThrow(() -> new IdException("Incorrect ID of a Doctor!"));
    }
}
