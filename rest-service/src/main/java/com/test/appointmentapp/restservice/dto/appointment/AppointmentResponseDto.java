package com.test.appointmentapp.restservice.dto.appointment;

import com.test.appointmentapp.restservice.dto.doctor.DoctorResponseDto;
import com.test.appointmentapp.restservice.dto.patient.PatientResponseDto;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentResponseDto {
    private Long id;
    private DoctorResponseDto doctor;
    private PatientResponseDto patient;
    private LocalDateTime startTime;
}