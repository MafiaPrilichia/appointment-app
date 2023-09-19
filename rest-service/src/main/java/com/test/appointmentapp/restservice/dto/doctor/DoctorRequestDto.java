package com.test.appointmentapp.restservice.dto.doctor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DoctorRequestDto {
    @NotNull
    @NotBlank
    private String snp;
}