package com.seb.patientmanager.data.model;

import com.seb.patientmanager.data.enums.Gender;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @Past
    private LocalDate birthDate;

    @NotNull
    private Gender gender;

    private String nationalIdentificationNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "note_id", referencedColumnName = "id")
    private Note note;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Email> emails = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<PhoneNumber> phoneNumbers = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<History> histories = new HashSet<>();

    public Patient() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public String getNationalIdentificationNumber() {
        return nationalIdentificationNumber;
    }

    public Address getAddress() {
        return address;
    }

    public Note getNote() {
        return note;
    }

    public Set<Email> getEmails() {
        return emails;
    }

    public Set<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public Set<History> getHistories() {
        return histories;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setNationalIdentificationNumber(String nationalIdentificationNumber) {
        this.nationalIdentificationNumber = nationalIdentificationNumber;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Patient patient)) {
            return false;
        }

        if (!getId().equals(patient.getId())) {
            return false;
        }
        if (!getFirstName().equals(patient.getFirstName())) {
            return false;
        }
        if (!getLastName().equals(patient.getLastName())) {
            return false;
        }
        if (!getBirthDate().equals(patient.getBirthDate())) {
            return false;
        }
        if (getGender() != patient.getGender()) {
            return false;
        }

        return getNationalIdentificationNumber() != null ? !getNationalIdentificationNumber().equals(patient.getNationalIdentificationNumber()) : patient.getNationalIdentificationNumber() != null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getBirthDate().hashCode();
        result = 31 * result + getGender().hashCode();
        result = 31 * result + (getNationalIdentificationNumber() != null ? getNationalIdentificationNumber().hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", gender=" + gender +
                ", nationalIdentificationNumber='" + nationalIdentificationNumber + '\'' +
                '}';
    }
}
