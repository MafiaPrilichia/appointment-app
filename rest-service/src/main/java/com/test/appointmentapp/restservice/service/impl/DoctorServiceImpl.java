package com.test.appointmentapp.restservice.service.impl;

import com.test.appointmentapp.restservice.dto.doctor.DoctorRequestDto;
import com.test.appointmentapp.restservice.mapper.DoctorMapper;
import com.test.appointmentapp.restservice.repository.DoctorRepository;
import com.test.appointmentapp.restservice.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("doctorService")
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository repository;
    private final DoctorMapper mapper;

    @Override
    @Transactional
    public void createDoctor(DoctorRequestDto doctorRequest) {
        repository.save(mapper.createDoctor(doctorRequest.getSnp()));
    }
}