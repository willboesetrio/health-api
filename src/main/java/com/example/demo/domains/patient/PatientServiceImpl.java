package com.example.demo.domains.patient;

import com.example.demo.domains.encounter.Encounter;
import com.example.demo.domains.encounter.EncounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/**
 * contains logic for the service layer of patient entity
 * @author Will Boese
 */
@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private EncounterRepository encounterRepository;

    /**
     * gets all patients from database
     * @return
     */
    @Override
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    /**
     * gets a specific patient by ID
     * @param id
     * @return
     */
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

    /**
     * creates a new patient, throws 409 if patient email already exists in database
     * @param patient
     * @return
     */
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

    /**
     * updates patient in database, throws 409 if incoming email exists on another patient in database
     * @param id
     * @param patient
     * @return
     */
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
        // check if this patient has any encounters
        List<Encounter> allEncountersForPatient = encounterRepository.findByPatientId(id);
        if (allEncountersForPatient.isEmpty()) {
            patientRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

}
