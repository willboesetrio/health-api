package com.example.demo.domains.patient;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * interface for patient entity service layer, methods implemented in PatientServiceImpl
 * @author Will Boese
 */
@Service
public interface PatientService {

    List<Patient> getAll();

    Patient getById(Long id);

    Patient createPatient(Patient patient);

    Patient updatePatient(Long id, Patient patient);

    void deletePatient(Long id);
}
