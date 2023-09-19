package com.test.appointmentapp.restservice.controller;

import com.test.appointmentapp.restservice.dto.patient.PatientRequestDto;
import com.test.appointmentapp.restservice.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patient")
@Validated
public class PatientController {
    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<String> addPatient(@Valid @RequestBody PatientRequestDto patient) {
        patientService.createPatient(patient);
        return ResponseEntity.ok(String.format("Added a patient %s", patient.getSnp()));
    }
}