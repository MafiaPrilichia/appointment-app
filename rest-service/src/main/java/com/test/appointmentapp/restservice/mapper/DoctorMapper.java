package com.test.appointmentapp.restservice.mapper;

import com.test.appointmentapp.restservice.dto.doctor.DoctorResponseDto;
import com.test.appointmentapp.restservice.entity.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    DoctorResponseDto entityToDto(Doctor entity);

    @Mapping(target = "id", ignore = true)
    Doctor createDoctor(String snp);
}