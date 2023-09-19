package com.test.appointmentapp.restservice.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "doctors")
@Data
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private UUID uuid;

    @Column(nullable = false)
    private String snp;

    @OneToMany(mappedBy = "doctor",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Appointment> appointments;

    public Doctor() {
        this.uuid = UUID.randomUUID();
    }
}