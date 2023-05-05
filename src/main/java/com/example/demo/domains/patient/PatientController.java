package com.example.demo.domains.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * contains all routing for retrieving patients from database
 * @author Will Boese
 */
@RestController
@RequestMapping(path = "/patients")
@CrossOrigin
public class PatientController {

    @Autowired
    private PatientService patientService;

    /**
     * gets all patients in database
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        return new ResponseEntity<>(patientService.getAll(), HttpStatus.OK);
    }

    /**
     * gets one patient by specific ID
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        return new ResponseEntity<>(patientService.getById(id), HttpStatus.OK);
    }

    /**
     * creates a new patient in database
     * @param patient
     * @return
     */
    @PostMapping
    public ResponseEntity<Patient> createPatient(@Valid @RequestBody Patient patient) {
        return new ResponseEntity<>(patientService.createPatient(patient), HttpStatus.CREATED);
    }

    /**
     * edits an existing patient
     * @param id
     * @param patient
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(
            @PathVariable Long id, @Valid @RequestBody Patient patient) {
        return new ResponseEntity<>(patientService.updatePatient(id, patient), HttpStatus.OK);
    }

    /**
     * deletes an existing patient
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Patient> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
