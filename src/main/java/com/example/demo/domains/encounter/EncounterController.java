package com.example.demo.domains.encounter;

import com.example.demo.domains.patient.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@CrossOrigin
public class EncounterController {

    @Autowired
    EncounterService encounterService;

    @GetMapping("/patients/{patientId}/encounters")
    public ResponseEntity<List<Encounter>> getAllEncounters(@PathVariable Long patientId) {
        return new ResponseEntity<>(encounterService.getAll(patientId), HttpStatus.OK);
    }

    @GetMapping(("/patients/{patientId}/encounters/{id}"))
    public ResponseEntity<Encounter> getEncounterById(@PathVariable Long patientId, @PathVariable Long id) {
        return new ResponseEntity<>(encounterService.getById(patientId, id), HttpStatus.OK);
    }

    @PostMapping("/patients/{patientId}/encounters")
    public ResponseEntity<Encounter> createPatient(@Valid @RequestBody Encounter encounter, @PathVariable Long patientId) {
        return new ResponseEntity<>(encounterService.createEncounter(encounter, patientId), HttpStatus.CREATED);
    }

    @PutMapping("/patients/{patientId}/encounters/{id}")
    public ResponseEntity<Encounter> updateEncounter(@Valid @RequestBody Encounter encounter, @PathVariable Long patientId, @PathVariable Long id) {
        return new ResponseEntity<>(encounterService.updateEncounter(encounter, id, patientId), HttpStatus.OK);
    }

    @DeleteMapping("/patients/{patientId}/encounters/{id}")
    public ResponseEntity<Encounter> deleteEncounter(@PathVariable Long patientId, @PathVariable Long id) {
        encounterService.deleteEncounter(patientId, id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
