package com.test.appointmentapp.restservice.service.impl;

import com.test.appointmentapp.restservice.dto.appointment.AppointmentRequestDto;
import com.test.appointmentapp.restservice.dto.appointment.AppointmentResponseDto;
import com.test.appointmentapp.restservice.entity.Appointment;
import com.test.appointmentapp.restservice.entity.Patient;
import com.test.appointmentapp.restservice.exception.DuplicateException;
import com.test.appointmentapp.restservice.exception.IdException;
import com.test.appointmentapp.restservice.mapper.AppointmentMapper;
import com.test.appointmentapp.restservice.repository.AppointmentRepository;
import com.test.appointmentapp.restservice.service.AppointmentService;
import com.test.appointmentapp.restservice.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("appointmentService")
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository repository;
    private final AppointmentMapper mapper;
    private final PatientService patientService;

    @Override
    public List<AppointmentResponseDto> getAvailableAppointmentsByDoctorAndDate(AppointmentRequestDto appointment) {
        return repository.findAvailableAppointmentsByDoctorAndDate(appointment.getDoctorId(), appointment.getAppointmentDate())
                .stream()
                .map(mapper::entityToResponseDto)
                .toList();
    }

    @Override
    @Transactional
    public void takeAppointmentById(Long id, Long patientId, UUID patientUuid) {
        Appointment appointment = getAppointmentEntityById(id);
        if (appointment.getPatient() != null) {
            throw new DuplicateException("The appointment is already taken!");
        }
        Patient patient = patientService.getPatientEntity(patientId, patientUuid);
        appointment.setPatient(patient);
        updateAppointment(appointment);
    }

    @Override
    public Appointment getAppointmentEntityById(Long id) {
        Optional<Appointment> appointment = repository.findById(id.toString());
        return appointment.orElseThrow(() -> new IdException("Incorrect ID of an Appointment!"));
    }

    @Override
    @Transactional
    public void updateAppointment(Appointment appointment) {
        repository.save(appointment);
    }

    @Override
    public List<AppointmentResponseDto> getAppointmentsByPatient(Long patientId, UUID patientUuid) {
        return repository.findAppointmentsByPatient(patientId, patientUuid)
                .stream()
                .map(mapper::entityToResponseDto)
                .toList();
    }
}