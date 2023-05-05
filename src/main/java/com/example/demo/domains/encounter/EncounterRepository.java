package com.example.demo.domains.encounter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import java.util.List;

/**
 * CRUD repository for encounter entity
 * @author Will Boese
 */
@Repository
@Validated
public interface EncounterRepository extends JpaRepository<Encounter, Long> {

    /**
     * finds all encounter matching a specific patient ID
     * @param patientId
     * @return
     */
    List<Encounter> findByPatientId(Long patientId);
}
