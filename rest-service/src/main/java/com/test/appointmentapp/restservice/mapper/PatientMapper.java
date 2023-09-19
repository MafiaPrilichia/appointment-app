package com.test.appointmentapp.restservice.mapper;

import com.test.appointmentapp.restservice.dto.patient.PatientResponseDto;
import com.test.appointmentapp.restservice.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.sql.Date;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    PatientResponseDto entityToDto(Patient entity);

    @Mapping(target = "id", ignore = true)
    Patient createPatient(String snp, Date birthday);
}