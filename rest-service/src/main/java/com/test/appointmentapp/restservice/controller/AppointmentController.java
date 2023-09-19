package com.test.appointmentapp.restservice.controller;

import com.test.appointmentapp.restservice.dto.appointment.AppointmentRequestDto;
import com.test.appointmentapp.restservice.dto.appointment.AppointmentResponseDto;
import com.test.appointmentapp.restservice.service.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/appointment")
@RequiredArgsConstructor
@Validated
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping("/doctor-date")
    public ResponseEntity<List<AppointmentResponseDto>> getAvailableAppointmentsByDoctorAndDate(@Valid @RequestBody AppointmentRequestDto appointment) {
        return ResponseEntity.ok(appointmentService.getAvailableAppointmentsByDoctorAndDate(appointment));
    }

    @PostMapping("/{appointmentId}/take")
    public ResponseEntity<String> takeAppointmentById(
            @PathVariable Long appointmentId,
            @RequestParam(name = "id", required = false) Long patientId,
            @RequestParam(name = "uuid", required = false) UUID patientUuid
    ) {
        appointmentService.takeAppointmentById(appointmentId, patientId, patientUuid);
        return ResponseEntity.ok("Appointment successfully taken!");
    }

    @GetMapping("/patient")
    public ResponseEntity<List<AppointmentResponseDto>> getAppointmentsByPatient(
            @RequestParam(name = "id", required = false) Long patientId,
            @RequestParam(name = "uuid", required = false) UUID patientUuid
    ) {
        return ResponseEntity.ok(appointmentService.getAppointmentsByPatient(patientId, patientUuid));
    }
}