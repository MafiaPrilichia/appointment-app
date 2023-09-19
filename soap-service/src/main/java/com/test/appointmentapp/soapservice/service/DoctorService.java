package com.test.appointmentapp.soapservice.service;

import com.test.appointmentapp.soapservice.entity.Doctor;

public interface DoctorService {
    Doctor getDoctorEntityById(Long id);
}