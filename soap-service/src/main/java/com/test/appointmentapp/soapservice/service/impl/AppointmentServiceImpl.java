package com.test.appointmentapp.soapservice.service.impl;

import com.test.appointmentapp.soapservice.entity.Appointment;
import com.test.appointmentapp.soapservice.entity.Doctor;
import com.test.appointmentapp.soapservice.exception.DatatypeException;
import com.test.appointmentapp.soapservice.exception.ValidationException;
import com.test.appointmentapp.soapservice.repository.AppointmentRepository;
import com.test.appointmentapp.soapservice.service.AppointmentService;
import com.test.appointmentapp.soapservice.service.DoctorService;
import com.test.appointmentapp.soapservice.xml.AppointmentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

@Service("appointmentService")
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository repository;
    private final DoctorService doctorService;

    @Override
    @Transactional
    public void addAppointment(AppointmentRequest appointmentRequest) {
        Doctor doctor = doctorService.getDoctorEntityById(appointmentRequest.getDoctorId());
        for (int i = 0; i < appointmentRequest.getCount(); i++) {
            Appointment appointment = new Appointment();
            appointment.setDoctor(doctor);
            XMLGregorianCalendar startTime = appointmentRequest.getStartTime();
            if (i != 0) {
                try {
                    startTime.add(DatatypeFactory.newInstance().newDuration("PT" + appointmentRequest.getDuration() + "M"));
                    if (repository.findByDoctorIdAndStartTime(
                            appointmentRequest.getDoctorId(),
                            startTime.toGregorianCalendar().toZonedDateTime().toLocalDateTime()).isPresent()
                    ) {
                        throw new ValidationException("Incorrect startTime! This appointment already exists!");
                    }
                } catch (DatatypeConfigurationException e) {
                    throw new DatatypeException(e.getMessage());
                }
            }
            appointment.setStartTime(startTime.toGregorianCalendar().toZonedDateTime().toLocalDateTime());
            repository.save(appointment);
        }
    }
}