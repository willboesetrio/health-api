package com.example.demo.data;

import com.example.demo.domains.patient.Patient;
import com.example.demo.domains.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;
    private Patient patient1;
    private Patient patient2;
    private Patient patient3;
    private Patient patient4;
    private Patient patient5;
    private Patient patient6;

    @Override
    public void run(String... strings) throws Exception{
        loadPatients();
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
       patient6 = patientRepository.save(new Patient("VALIDATION",
               "TESTER",
               null,
               null,
               null,
               null,
               null));
    }
}
