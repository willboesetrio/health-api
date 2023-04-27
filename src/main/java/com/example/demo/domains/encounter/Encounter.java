package com.example.demo.domains.encounter;

import com.example.demo.domains.patient.Patient;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

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
    @NotEmpty
    private String notes;
    @NotNull
    @NotEmpty
    private String visitCode;
    @NotNull
    @NotEmpty
    private String provider;
    @NotNull
    @NotEmpty
    private String billingCode;
    @NotNull
    @NotEmpty
    private String icd10;
    @NotNull
    private double totalCost;
    @NotNull
    private double copay;
    @NotNull
    @NotEmpty
    private String cheifComplaint;
    private int pulse;
    private int systolic;
    private int diastolic;
    @NotNull
    private Date date;

    public Encounter() {
    }

    public Encounter(Patient patient, String notes, String visitCode, String provider, String billingCode, String icd10, double totalCost, double copay, String cheifComplaint, int pulse, int systolic, int diastolic, Date date) {
        this.patient = patient;
        this.notes = notes;
        this.visitCode = visitCode;
        this.provider = provider;
        this.billingCode = billingCode;
        this.icd10 = icd10;
        this.totalCost = totalCost;
        this.copay = copay;
        this.cheifComplaint = cheifComplaint;
        this.pulse = pulse;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.date = date;
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

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getBillingCode() {
        return billingCode;
    }

    public void setBillingCode(String billingCode) {
        this.billingCode = billingCode;
    }

    public String getIcd10() {
        return icd10;
    }

    public void setIcd10(String icd10) {
        this.icd10 = icd10;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getCopay() {
        return copay;
    }

    public void setCopay(double copay) {
        this.copay = copay;
    }

    public String getCheifComplaint() {
        return cheifComplaint;
    }

    public void setCheifComplaint(String cheifComplaint) {
        this.cheifComplaint = cheifComplaint;
    }

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }

    public int getSystolic() {
        return systolic;
    }

    public void setSystolic(int systolic) {
        this.systolic = systolic;
    }

    public int getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(int diastolic) {
        this.diastolic = diastolic;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Encounter{" +
                "id=" + id +
                ", patient=" + patient +
                ", notes='" + notes + '\'' +
                ", visitCode='" + visitCode + '\'' +
                ", provider='" + provider + '\'' +
                ", billingCode='" + billingCode + '\'' +
                ", icd10='" + icd10 + '\'' +
                ", totalCost=" + totalCost +
                ", copay=" + copay +
                ", cheifComplaint='" + cheifComplaint + '\'' +
                ", pulse=" + pulse +
                ", systolic=" + systolic +
                ", diastolic=" + diastolic +
                ", date=" + date +
                '}';
    }
}

