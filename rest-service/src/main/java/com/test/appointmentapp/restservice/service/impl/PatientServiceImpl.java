package com.test.appointmentapp.restservice.service.impl;

import com.test.appointmentapp.restservice.dto.patient.PatientRequestDto;
import com.test.appointmentapp.restservice.entity.Patient;
import com.test.appointmentapp.restservice.exception.IdException;
import com.test.appointmentapp.restservice.mapper.PatientMapper;
import com.test.appointmentapp.restservice.repository.PatientRepository;
import com.test.appointmentapp.restservice.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service("patientService")
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository repository;
    private final PatientMapper mapper;

    @Override
    public Patient getPatientEntityById(Long id) {
        Optional<Patient> patient = repository.findById(id.toString());
        return patient.orElseThrow(() -> new IdException("Incorrect ID of a Patient"));
    }

    @Override
    public Patient getPatientEntityByUuid(UUID uuid) {
        Optional<Patient> appointment = repository.findByUuid(uuid);
        return appointment.orElseThrow(() -> new IdException("Incorrect UUID of a Patient"));
    }

    @Override
    public Patient getPatientEntity(Long id, UUID uuid) {
        if (id != null) {
            return getPatientEntityById(id);
        } else if (uuid != null) {
            return getPatientEntityByUuid(uuid);
        } else {
            throw new IdException("ID and UUID are null! At least one parameter must be not null!");
        }
    }

    @Override
    @Transactional
    public void createPatient(PatientRequestDto patientRequest) {
        repository.save(mapper.createPatient(patientRequest.getSnp(), patientRequest.getBirthday()));
    }
}