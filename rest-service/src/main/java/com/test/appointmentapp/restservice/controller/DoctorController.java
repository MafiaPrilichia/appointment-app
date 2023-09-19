package com.test.appointmentapp.restservice.controller;

import com.test.appointmentapp.restservice.dto.doctor.DoctorRequestDto;
import com.test.appointmentapp.restservice.service.DoctorService;
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
@RequestMapping("/doctor")
@Validated
public class DoctorController {
    private final DoctorService doctorService;

    @PostMapping
    public ResponseEntity<String> addDoctor(@Valid @RequestBody DoctorRequestDto doctor) {
        doctorService.createDoctor(doctor);
        return ResponseEntity.ok(String.format("Added a doctor %s", doctor.getSnp()));
    }
}