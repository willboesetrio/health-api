package com.example.demo.domains.encounter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class EncounterServiceImpl implements  EncounterService{

    @Autowired
    EncounterRepository encounterRepository;

    @Override
    public List<Encounter> getAll() {
        return encounterRepository.findAll();
    }

    @Override
    public Encounter createEncounter(Encounter encounter) {
        return encounterRepository.save(encounter);
    }
}
