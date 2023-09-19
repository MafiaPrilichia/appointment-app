package com.test.appointmentapp.restservice.mapper;

import com.test.appointmentapp.restservice.dto.appointment.AppointmentResponseDto;
import com.test.appointmentapp.restservice.entity.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "doctor", target = "doctor")
    @Mapping(source = "patient", target = "patient")
    @Mapping(source = "startTime", target = "startTime")
    AppointmentResponseDto entityToResponseDto(Appointment entity);
}