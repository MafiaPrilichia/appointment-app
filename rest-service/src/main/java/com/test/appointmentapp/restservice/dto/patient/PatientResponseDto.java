package com.test.appointmentapp.restservice.dto.patient;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class PatientResponseDto {
    private Long id;
    private UUID uuid;
    private String snp;
    private Date birthday;
}