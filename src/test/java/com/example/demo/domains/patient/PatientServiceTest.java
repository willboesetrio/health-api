package com.example.demo.domains.patient;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Example;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyCollection;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

class PatientServiceTest {

    @Mock
    PatientRepository patientRepository;
    @Mock
    PatientService patientService;
    @InjectMocks
    PatientServiceImpl patientServiceImpl;

    Patient testPatient;
    Patient testPatient2;
    List<Patient> testList = new ArrayList<>();

    @BeforeEach
    @SuppressWarnings("unchecked")
    public void setUp() {
        //initialize mocks
        MockitoAnnotations.initMocks(this);

        testPatient = new Patient("testfirst",
                "testlast",
                "123-45-6789",
                "testing@gmail.com",
                "5432 testing way",
                "Rutherfordton",
                "IL",
                "12345",
                66,
                68,
                205,
                "Blue Cross",
                "Male");
        testPatient2 = new Patient("testfirst",
                "testlast",
                "123-45-6789",
                "testing2@gmail.com",
                "5432 testing way",
                "Rutherfordton",
                "IL",
                "12345",
                66,
                68,
                205,
                "Blue Cross",
                "Male");
        testPatient.setId(1l);
        testList.add(testPatient);
        patientRepository.save(testPatient);

       //hen(patientRepository.findAll().thenReturn(testList));
        doReturn(testList).when(patientRepository).findAll();
        when(patientRepository.findById(any(Long.class))).thenReturn(Optional.of(testList.get(0)));
        when(patientRepository.save(any(Patient.class))).thenReturn(testPatient2);


    }

    @Test
    void getAll() {
        List<Patient> result = patientServiceImpl.getAll();
        assertEquals(testList, result);
    }

    @Test
    void getById() {
        Patient result = patientServiceImpl.getById(1L);
        assertEquals(testPatient, result);
    }

    @Test
    void createPatient() {
        Patient result = patientServiceImpl.createPatient(testPatient2);
        assertEquals(testPatient2, result);
    }

    @Test
    void updatePatient() {
        Patient result = patientServiceImpl.updatePatient(1L, testPatient2);
        assertEquals(testPatient2, result);
    }

    @Test
    void deletePatient() {
    }
}