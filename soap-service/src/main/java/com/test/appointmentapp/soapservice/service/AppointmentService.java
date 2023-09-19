package com.test.appointmentapp.soapservice.service;

import com.test.appointmentapp.soapservice.xml.AppointmentRequest;

public interface AppointmentService {
    void addAppointment(AppointmentRequest appointmentRequest);
}