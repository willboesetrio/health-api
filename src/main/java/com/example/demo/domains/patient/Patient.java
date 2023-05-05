package com.example.demo.domains.patient;

import com.example.demo.domains.encounter.Encounter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

/**
 * represents patient table in the database
 * @author Will Boese
 */
@Entity
public class Patient {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 1, max=35)
    @Pattern(regexp = "^[A-Za-z'\\-]+$", message = "firstname err")
    private String firstName;
    @NotNull
    @Size(min = 1, max=35)
    @Pattern(regexp = "^[A-Za-z'\\-]+$", message = "lastname err")
    private String lastName;
    @NotNull
    @Pattern(regexp = "^\\d{3}-\\d{2}-\\d{4}$", message = "invalid ssn")
    private String ssn;
    @NotNull
    @Column(unique = true)
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$", message = "invalid email")
    private String email;
    @NotNull
    @NotEmpty
    private String street;
    @NotNull
    @NotEmpty
    private String city;
    @NotNull
    @Pattern(regexp = "^(?-i:A[LKSZRAEP]|C[AOT]|D[EC]|F[LM]|G[AU]|HI|I[ADLN]|K[SY]|LA|M[ADEHINOPST]|N[CDEHJMVY]|O[HKR]|P[ARW]|RI|S[CD]|T[NX]|UT|V[AIT]|W[AIVY])$", message = "invalid state")
    private String state;
    @NotNull
    @Pattern(regexp = "^\\d{5}$|^\\d{5}-\\d{4}$", message = "invalid zip")
    private String postal;
    @NotNull
    @Min(0)
    private int age;
    @NotNull
    @Min(0)
    private int height;
    @NotNull
    @Min(0)
    private int weight;
    @NotNull
    private
    String insurance;
    @NotNull
    @Pattern(regexp = "(?i)^Male$|^Female$|^Other$", message = "gender option error")
    private String gender;
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "patient")
//    private Set<Encounter> encounters;

    public Patient() {
    }

    public Patient(String firstName, String lastName, String ssn, String email, String street, String city, String state, String postal, int age, int height, int weight, String insurance, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.email = email;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postal = postal;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.insurance = insurance;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ssn='" + ssn + '\'' +
                ", email='" + email + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postal='" + postal + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", insurance='" + insurance + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
