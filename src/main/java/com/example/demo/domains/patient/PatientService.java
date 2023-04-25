package com.example.demo.domains.patient;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService {

    List<Patient> getAll();
}
