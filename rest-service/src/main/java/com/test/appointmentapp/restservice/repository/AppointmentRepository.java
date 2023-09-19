package com.test.appointmentapp.restservice.repository;

import com.test.appointmentapp.restservice.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, String> {
    @Query("FROM Appointment a " +
            "WHERE a.doctor.id = :doctorId " +
            "AND DATE(a.startTime) = :date " +
            "AND a.patient IS NULL")
    List<Appointment> findAvailableAppointmentsByDoctorAndDate(@Param("doctorId") Long doctorId,
                                                               @Param("date") LocalDateTime date);

    @Query("FROM Appointment a " +
            "WHERE a.patient.id = :patientId " +
            "OR a.patient.uuid = :patientUuid")
    List<Appointment> findAppointmentsByPatient(Long patientId, UUID patientUuid);
}