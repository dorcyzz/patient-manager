package com.seb.patientmanager.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull
    private String street;

    @NotNull
    private Integer streetNumber;

    @NotNull
    private Integer postalCode;

    @NotNull
    private String city;

    @NotNull
    private String country;

    @JsonIgnore
    @OneToOne(mappedBy = "address")
    private Patient patient;

    public Address() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Address address)) {
            return false;
        }

        if (!getId().equals(address.getId())) {
            return false;
        }
        if (!getStreet().equals(address.getStreet())) {
            return false;
        }
        if (!getStreetNumber().equals(address.getStreetNumber())) {
            return false;
        }
        if (!getPostalCode().equals(address.getPostalCode())) {
            return false;
        }
        if (!getCity().equals(address.getCity())) {
            return false;
        }
        if (!getPatient().equals(address.getPatient())) {
            return false;
        }

        return getCountry().equals(address.getCountry());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getStreet().hashCode();
        result = 31 * result + getStreetNumber().hashCode();
        result = 31 * result + getPostalCode().hashCode();
        result = 31 * result + getCity().hashCode();
        result = 31 * result + getCountry().hashCode();
        result = 31 * result + getPatient().hashCode();

        return result;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", streetNumber=" + streetNumber +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", patient='" + patient + '\'' +
                '}';
    }
}
