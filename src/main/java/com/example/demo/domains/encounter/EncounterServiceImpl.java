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


@Service
@Validated
public class EncounterServiceImpl implements  EncounterService{

    @Autowired
    EncounterRepository encounterRepository;
    @Autowired
    PatientRepository patientRepository;

    @Override
    public List<Encounter> getAll(Long patientId) {
        return encounterRepository.findByPatientId(patientId);
    }

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

    @Override
    public Encounter updateEncounter(Long id, Encounter encounter) {
        try {
            Optional<Encounter> encounterToUpdate = encounterRepository.findById(id);
            if (encounterToUpdate.isEmpty()) {
                throw new ResourceNotFoundException();
            } else {
                encounter.setId(id);
                encounterRepository.save(encounter);
            }
        } catch (DataAccessException e) {
            // logger.error(e.getMessage());
        }

        return encounter;
    }

    @Override
    public void deleteEncounter(Long id) {
        encounterRepository.deleteById(id);
    }
}
