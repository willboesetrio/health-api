package com.example.demo.domains.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CRUD repository for patient entity
 * @author Will Boese
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
