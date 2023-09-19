package com.test.appointmentapp.restservice.service;

import com.test.appointmentapp.restservice.dto.doctor.DoctorRequestDto;

public interface DoctorService {
    void createDoctor(DoctorRequestDto doctorRequest);
}