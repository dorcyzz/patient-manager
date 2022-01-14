package com.seb.patientmanager.data.model;

import com.seb.patientmanager.data.enums.VisitType;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull
    private VisitType visitType;

    @NotNull
    private LocalDate date;

    private String note;

    public History() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public VisitType getVisitType() {
        return visitType;
    }

    public void setVisitType(VisitType visitType) {
        this.visitType = visitType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof History history)) {
            return false;
        }

        if (!getId().equals(history.getId())) {
            return false;
        }
        if (getVisitType() != history.getVisitType()) {
            return false;
        }
        if (!getDate().equals(history.getDate())) {
            return false;
        }

        return getNote() != null ? getNote().equals(history.getNote()) : history.getNote() == null;
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getVisitType().hashCode();
        result = 31 * result + getDate().hashCode();
        result = 31 * result + (getNote() != null ? getNote().hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", visitType=" + visitType +
                ", date=" + date +
                ", note='" + note + '\'' +
                '}';
    }
}
