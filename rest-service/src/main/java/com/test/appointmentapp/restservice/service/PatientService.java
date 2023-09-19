package com.test.appointmentapp.restservice.service;

import com.test.appointmentapp.restservice.dto.patient.PatientRequestDto;
import com.test.appointmentapp.restservice.entity.Patient;

import java.util.UUID;

public interface PatientService {
    Patient getPatientEntityById(Long id);
    Patient getPatientEntityByUuid(UUID uuid);
    Patient getPatientEntity(Long id, UUID uuid);
    void createPatient(PatientRequestDto patientRequest);
}