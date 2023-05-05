package com.example.demo.domains.encounter;

import com.example.demo.domains.patient.Patient;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import com.fasterxml.jackson.annotation.*;

/**
 * represents encounter table in the database
 * @author Will Boese
 */
@Entity
@Validated
public class Encounter {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    @JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("patient_id")
    private Patient patient;
    @NotNull
    @NotEmpty
    private String notes;
    @NotNull
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z][0-9][a-zA-Z][ ][0-9][a-zA-Z][0-9]$", message="visit code err")
    private String visitCode;
    @NotNull
    @NotEmpty
    private String provider;
    @NotNull
    @NotEmpty
    @Pattern(regexp = "^\\d{3}.\\d{3}.\\d{3}-\\d{2}$", message="billing code err")
    private String billingCode;
    @NotNull
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z][\\d][\\d]$", message = "icd10 err")
    private String icd10;
    @NotNull
    @Min(0)
    private double totalCost;
    @NotNull
    @Min(0)
    private double copay;
    @NotNull
    @NotEmpty
    private String chiefComplaint;
    private int pulse;
    private int systolic;
    private int diastolic;
    @NotNull
    private Date date;

    public Encounter() {
    }

    public Encounter(Patient patient, String notes, String visitCode, String provider, String billingCode, String icd10, double totalCost, double copay, String chiefComplaint, int pulse, int systolic, int diastolic, Date date) {
        this.patient = patient;
        this.notes = notes;
        this.visitCode = visitCode;
        this.provider = provider;
        this.billingCode = billingCode;
        this.icd10 = icd10;
        this.totalCost = totalCost;
        this.copay = copay;
        this.chiefComplaint = chiefComplaint;
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

    public String getChiefComplaint() {
        return chiefComplaint;
    }

    public void setChiefComplaint(String chiefComplaint) {
        this.chiefComplaint = chiefComplaint;
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
                ", chiefComplaint='" + chiefComplaint + '\'' +
                ", pulse=" + pulse +
                ", systolic=" + systolic +
                ", diastolic=" + diastolic +
                ", date=" + date +
                '}';
    }
}

