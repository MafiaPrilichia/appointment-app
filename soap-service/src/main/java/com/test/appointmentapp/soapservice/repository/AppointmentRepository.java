package com.test.appointmentapp.soapservice.repository;

import com.test.appointmentapp.soapservice.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, String> {
    Optional<Appointment> findByDoctorIdAndStartTime(Long doctorId, LocalDateTime startTime);
}