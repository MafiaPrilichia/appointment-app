package com.test.appointmentapp.restservice.repository;

import com.test.appointmentapp.restservice.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {
    @Query("FROM Patient p WHERE p.uuid = :uuid")
    Optional<Patient> findByUuid(@Param("uuid") UUID uuid);
}