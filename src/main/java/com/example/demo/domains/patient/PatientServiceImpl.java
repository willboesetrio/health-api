package com.example.demo.domains.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        if (patient.isEmpty()) {
            throw new ResourceNotFoundException();
        } else {
            return patient.get();
        }
    }

    @Override
    public Patient createPatient(Patient patient) {
        List<Patient> allPatients = patientRepository.findAll();
        for (Patient p : allPatients) {
            if (p.getEmail().equals(patient.getEmail())) {
                throw new ResponseStatusException(HttpStatus.CONFLICT);
            }
        }
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Long id, Patient patient) {
        try {
            Optional<Patient> patientToUpdate = patientRepository.findById(id);
            if (patientToUpdate.isEmpty()) {
                throw new ResourceNotFoundException();
            } else {
                patient.setId(id);
                List<Patient> allPatients = patientRepository.findAll();
                allPatients.remove(patientToUpdate.get());
                for (Patient p : allPatients) {
                    if (p.getEmail().equals(patient.getEmail())) {
                        throw new ResponseStatusException(HttpStatus.CONFLICT);
                    }
                }
                patientRepository.save(patient);
            }
        } catch (DataAccessException e) {
           // logger.error(e.getMessage());
        }

        return patient;
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

}
