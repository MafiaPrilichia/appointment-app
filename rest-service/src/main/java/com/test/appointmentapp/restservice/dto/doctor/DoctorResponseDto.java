package com.test.appointmentapp.restservice.dto.doctor;

import lombok.Data;

import java.util.UUID;

@Data
public class DoctorResponseDto {
    private Long id;
    private UUID uuid;
    private String snp;
}