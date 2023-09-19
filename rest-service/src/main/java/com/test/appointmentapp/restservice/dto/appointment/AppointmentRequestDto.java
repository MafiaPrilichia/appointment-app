package com.test.appointmentapp.restservice.dto.appointment;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentRequestDto {
    @NotNull
    @Positive
    private Long doctorId;
    @NotNull
    private LocalDateTime appointmentDate;
}