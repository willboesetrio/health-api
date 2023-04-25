package com.example.demo.domains.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientRepository patientRepository;
    @Override
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }
}
