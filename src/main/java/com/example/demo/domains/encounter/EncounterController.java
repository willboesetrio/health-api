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
@RequestMapping("/encounters")
public class EncounterController {

    @Autowired
    EncounterService encounterService;

    @GetMapping
    public ResponseEntity<List<Encounter>> getAllEncounters() {
        return new ResponseEntity<>(encounterService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Encounter> createPatient(@Valid @RequestBody Encounter encounter) {
        return new ResponseEntity<>(encounterService.createEncounter(encounter), HttpStatus.CREATED);
    }
}
