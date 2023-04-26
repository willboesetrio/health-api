package com.example.demo.domains.encounter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

@Repository
@Validated
public interface EncounterRepository extends JpaRepository<Encounter, Long> {
}
