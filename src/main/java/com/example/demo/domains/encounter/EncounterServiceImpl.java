package com.example.demo.domains.encounter;

import com.example.demo.domains.patient.Patient;
import com.example.demo.domains.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/**
 * contains logic for the service layer of encounter entity
 * @author Will Boese
 */
@Service
@Validated
public class EncounterServiceImpl implements  EncounterService{

    @Autowired
    EncounterRepository encounterRepository;
    @Autowired
    PatientRepository patientRepository;

    /**
     * gets all encounters from a specific patient ID
     * @param patientId
     * @return
     */
    @Override
    public List<Encounter> getAll(Long patientId) {
        return encounterRepository.findByPatientId(patientId);
    }

    /**
     * gets an individual encounter only if it exists in the list of encounters matching the passed in patient ID
     * @param patientId
     * @param id
     * @return
     */
    @Override
    public Encounter getById(Long patientId, Long id) {
        Optional<Encounter> encounter = Optional.empty();
        //encounter = encounterRepository.findById((id));
        List<Encounter> allEncountersForPatient = encounterRepository.findByPatientId(patientId);
        for (Encounter e : allEncountersForPatient)
        {
            if (e.getId().equals(id)){
                encounter = encounterRepository.findById(id);
            }
        }
        return encounter.get();
    }

    /**
     * creates a new encounter for the specified patient
     * @param encounter
     * @param patientId
     * @return
     */
    @Override
    public Encounter createEncounter(Encounter encounter, Long patientId) {
        Optional<Patient> currentPatient = patientRepository.findById(patientId);
        if (currentPatient.isEmpty()) {
        throw new ResourceNotFoundException();
        } else {
            encounter.setPatient(currentPatient.get());
        }
        // compare patientId on incoming encounter object to what is in the URL
//        if (!encounter.getPatient().getId().equals(patientId)) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//        }
        return encounterRepository.save(encounter);
    }

    /**
     * edits an encounter only if that encounter and patient already exist, and if that encounter already exists on that patient
     * @param encounter
     * @param id
     * @param patientId
     * @return
     */
    @Override
    public Encounter updateEncounter(Encounter encounter, Long id, Long patientId) {
        // check if patient exists
        Optional<Patient> patientToUpdate = patientRepository.findById(patientId);
        if (patientToUpdate.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        // get all encounters associated with the patient ID
        List<Encounter> allEncountersForPatient = encounterRepository.findByPatientId(patientId);
        // check if there is an encounter among that list that matches the incoming (encounter) ID
        boolean encounterExistsOnPatient = false;
        for (Encounter e : allEncountersForPatient)
        {
            if (e.getId().equals(id)){
                encounterExistsOnPatient = true;
            }
        }
        if (encounterExistsOnPatient) {
            encounter.setPatient(patientToUpdate.get());
            encounter.setId(id);
            encounterRepository.save(encounter);
        } else {
            throw  new ResourceNotFoundException();
        }
        return encounter;

    }

    /**
     * deletes a specified encounter only id the patient ID on the encounter matches the patient ID in URL
     * this method is actually not needed for front end project
     * @param patientId
     * @param id
     */
    @Override
    public void deleteEncounter(Long patientId, Long id) {
        Optional<Patient> patientToUpdate = patientRepository.findById(patientId);
        if (patientToUpdate.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        // get all encounters associated with the patient ID
        List<Encounter> allEncountersForPatient = encounterRepository.findByPatientId(patientId);
        // check if there is an encounter among that list that matches the incoming (encounter) ID
        boolean encounterExistsOnPatient = false;
        for (Encounter e : allEncountersForPatient)
        {
            if (e.getId().equals(id)){
                encounterExistsOnPatient = true;
            }
        }
        if (encounterExistsOnPatient) {
            encounterRepository.deleteById(id);
        } else {
            throw  new ResourceNotFoundException();
        }
    }
}
