package com.example.demo.domains.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientRepository patientRepository;
    @Override
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getById(Long id) {
        Optional<Patient> patient = Optional.empty();
        patient = patientRepository.findById((id));
        return patient.get();
    }

    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }
}
