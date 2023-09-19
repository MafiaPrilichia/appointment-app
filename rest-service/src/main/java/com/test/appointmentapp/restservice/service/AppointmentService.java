package com.test.appointmentapp.restservice.service;

import com.test.appointmentapp.restservice.dto.appointment.AppointmentRequestDto;
import com.test.appointmentapp.restservice.dto.appointment.AppointmentResponseDto;
import com.test.appointmentapp.restservice.entity.Appointment;

import java.util.List;
import java.util.UUID;

public interface AppointmentService {
    List<AppointmentResponseDto> getAvailableAppointmentsByDoctorAndDate(AppointmentRequestDto appointment);
    void takeAppointmentById(Long id, Long patientId, UUID patientUuid);
    Appointment getAppointmentEntityById(Long id);
    void updateAppointment(Appointment appointment);
    List<AppointmentResponseDto> getAppointmentsByPatient(Long patientId, UUID patientUuid);
}