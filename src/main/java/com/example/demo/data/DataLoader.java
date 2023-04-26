package com.example.demo.data;

import com.example.demo.domains.encounter.EncounterRepository;
import com.example.demo.domains.patient.Patient;
import com.example.demo.domains.encounter.Encounter;
import com.example.demo.domains.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    EncounterRepository encounterRepository;
    private Patient patient1;
    private Patient patient2;
    private Patient patient3;
    private Patient patient4;
    private Patient patient5;
    private Encounter encounter1;
    private Encounter encounter2;
    private Encounter encounter3;
    private Encounter encounter4;
    private Encounter encounter5;
    private Encounter encounter6;

    @Override
    public void run(String... strings) throws Exception{
        loadPatients();
        loadEncounters();
    }

    private void loadPatients() {
       patient1 = patientRepository.save(new Patient("Kyle",
               "Massey",
               "717-13-5432",
               "coryinthehouse@gmail.com",
               "28 Constitution Dr",
               "Champlin",
               "MN"));
       patient2 = patientRepository.save(new Patient("Robert",
               "Kelly",
               "555-55-5555",
               "ignition@gmail.com",
               "7262 Middle River St.",
               "Fort Myers",
               "FL"));
       patient3 = patientRepository.save(new Patient("Jared",
               "Fogle",
               "666-66-6666",
               "jared@quiznos.com",
               "41 3rd Ave.",
               "Belmont",
               "MA"));
       patient4 = patientRepository.save(new Patient("Drake",
               "Bell",
               "987-65-4321",
               "bestman@gmail.com",
               "8921 Park Lane",
               "Terre Haute",
               "IN"));
       patient5 = patientRepository.save(new Patient("Jeffrey",
               "Epstein",
               "123-45-6789",
               "didntoff@myself.com",
               "8 Armstrong Drive",
               "Rutherfordton",
               "IL"));
    }
    private void loadEncounters(){
        encounter1 = encounterRepository.save(new Encounter(patient1,"notes", "visit code"));
        encounter2 = encounterRepository.save(new Encounter(patient1,"pertains to patient1", "visit code"));
        encounter3 = encounterRepository.save(new Encounter(patient2,"notes", "visit code"));
        encounter4 = encounterRepository.save(new Encounter(patient2,"pertains to patient2", "visit code"));
        encounter5 = encounterRepository.save(new Encounter(patient3,"notes", "visit code333"));
        encounter6 = encounterRepository.save(new Encounter(patient4,"notes", "visit code444"));
    }
}
