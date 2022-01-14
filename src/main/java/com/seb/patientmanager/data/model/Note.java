package com.seb.patientmanager.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull
    @NotBlank
    private String note;

    @JsonIgnore
    @OneToOne(mappedBy = "note")
    private Patient patient;

    public Note() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Note note1)) {
            return false;
        }

        if (!getId().equals(note1.getId())) {
            return false;
        }

        if (!getPatient().equals(note1.getPatient())) {
            return false;
        }

        return getNote() != null ? getNote().equals(note1.getNote()) : note1.getNote() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + (getNote() != null ? getNote().hashCode() : 0);
        result = 31 * result + (getPatient() != null ? getPatient().hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", note='" + note + '\'' +
                ", patient='" + patient + '\'' +
                '}';
    }
}
