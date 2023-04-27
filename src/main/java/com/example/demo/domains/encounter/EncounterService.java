package com.example.demo.domains.encounter;

import com.example.demo.domains.patient.Patient;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public interface EncounterService {

    List<Encounter> getAll(Long patientId);

    Encounter getById (Long patientId, Long id);

    Encounter createEncounter(Encounter encounter);

    Encounter updateEncounter(Long id, Encounter encounter);

    void deleteEncounter(Long id);
}
