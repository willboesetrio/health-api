package com.example.demo.domains.encounter;

import com.example.demo.domains.patient.Patient;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Validated
public class Encounter {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @NotNull
    @NotBlank
    @NotEmpty
    private String notes;

    @NotNull
    @NotBlank
    @NotEmpty
    private String visitCode;

    public Encounter() {
    }

    public Encounter(Patient patient, String notes, String visitCode) {
        this.patient = patient;
        this.notes = notes;
        this.visitCode = visitCode;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getVisitCode() {
        return visitCode;
    }

    public void setVisitCode(String visitCode) {
        this.visitCode = visitCode;
    }

    @Override
    public String toString() {
        return "Encounter{" +
                "id=" + id +
                ", patient=" + patient +
                ", notes='" + notes + '\'' +
                ", visitCode='" + visitCode + '\'' +
                '}';
    }
}
