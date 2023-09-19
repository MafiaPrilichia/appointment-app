package com.test.appointmentapp.restservice.dto.patient;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.sql.Date;

@Data
public class PatientRequestDto {
    @NotNull
    @NotBlank
    private String snp;
    @NotNull
    @PastOrPresent
    private Date birthday;
}