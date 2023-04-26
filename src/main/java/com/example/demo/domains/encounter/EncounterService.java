package com.example.demo.domains.encounter;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public interface EncounterService {

    List<Encounter> getAll();

    Encounter createEncounter(Encounter encounter);
}
