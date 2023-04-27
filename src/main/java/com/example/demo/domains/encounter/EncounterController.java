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

    @PostMapping
    public ResponseEntity<Encounter> createPatient(@Valid @RequestBody Encounter encounter) {
        return new ResponseEntity<>(encounterService.createEncounter(encounter), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Encounter> updateEncounter(
            @PathVariable Long id, @Valid @RequestBody Encounter encounter) {
        return new ResponseEntity<>(encounterService.updateEncounter(id, encounter), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Encounter> deleteEncounter(@PathVariable Long id) {
        encounterService.deleteEncounter(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
