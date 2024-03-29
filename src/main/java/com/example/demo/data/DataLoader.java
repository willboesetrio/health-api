package com.example.demo.data;

import com.example.demo.domains.encounter.EncounterRepository;
import com.example.demo.domains.patient.Patient;
import com.example.demo.domains.encounter.Encounter;
import com.example.demo.domains.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Inserts data dummy data into the database once it is created
 * @author Will Boese
 */
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

    /**
     * calls helper methods which load data
     * @param strings
     * @throws Exception
     */
    @Override
    public void run(String... strings) throws Exception{
        loadPatients();
        loadEncounters();
    }

    /**
     * creates dummy data for patients
     */
    private void loadPatients() {
        patient1 = patientRepository.save(new Patient("Kyle",
                "Massey",
                "717-13-5432",
                "coryinthehouse@gmail.com",
                "28 Constitution Dr",
                "Champlin",
                "MN",
                "12345",
                31,
                65,
                210,
                "Blue Cross",
                "Male"
        ));
        patient2 = patientRepository.save(new Patient("Robert",
                "Kelly",
                "555-55-5555",
                "ignition@gmail.com",
                "7262 Middle River St.",
                "Fort Myers",
                "FL",
                "12345",
                57,
                73,
                190,
                "Blue Cross",
                "Male"));
        patient3 = patientRepository.save(new Patient("Jared",
                "Fogle",
                "666-66-6666",
                "jared@quiznos.com",
                "41 3rd Ave.",
                "Belmont",
                "MA",
                "12345",
                45,
                74,
                345,
                "Blue Cross",
                "Male"));
        patient4 = patientRepository.save(new Patient("Drake",
                "Bell",
                "987-65-4321",
                "bestman@gmail.com",
                "8921 Park Lane",
                "Terre Haute",
                "IN",
                "12345",
                36,
                69,
                175,
                "Blue Cross",
                "Male"));
        patient5 = patientRepository.save(new Patient("Jeffrey",
                "Epstein",
                "123-45-6789",
                "didntoff@myself.com",
                "8 Armstrong Drive",
                "Rutherfordton",
                "IL",
                "12345",
                66,
                68,
                205,
                "Blue Cross",
                "Male"));
    }

    /**
     * creates dummy data for encounters
     */
    private void loadEncounters(){
        encounter1 = encounterRepository.save(new Encounter(patient1,
                "notes",
                "D1D 1D1",
                "Dr. Phil",
                "123.456.789-12",
                "A22",
                299.99,
                99.99,
                "Concussion",
                80,
                120,
                80,
                new Date()));
        encounter2 = encounterRepository.save(new Encounter(patient1,
                "notes",
                "D1D 1D1",
                "Dr. Phil",
                "123.456.789-12",
                "A22",
                299.99,
                99.99,
                "Concussion",
                80,
                120,
                80,
                new Date()));
        encounter3 = encounterRepository.save(new Encounter(patient2,
                "notes",
                "D1D 1D1",
                "Dr. Phil",
                "123.456.789-12",
                "A22",
                299.99,
                99.99,
                "Concussion",
                80,
                120,
                80,
                new Date()));
        encounter4 = encounterRepository.save(new Encounter(patient2,
                "notes",
                "D1D 1D1",
                "Dr. Phil",
                "123.456.789-12",
                "A22",
                299.99,
                99.99,
                "Concussion",
                80,
                120,
                80,
                new Date()));
        encounter5 = encounterRepository.save(new Encounter(patient3,
                "notes",
                "D1D 1D1",
                "Dr. Phil",
                "123.456.789-12",
                "A22",
                299.99,
                99.99,
                "Concussion",
                80,
                120,
                80,
                new Date()));
        encounter6 = encounterRepository.save(new Encounter(patient4,
                "notes",
                "D1D 1D1",
                "Dr. Phil",
                "123.456.789-12",
                "A22",
                299.99,
                99.99,
                "Concussion",
                80,
                120,
                80,
                new Date()));
    }
}
