package com.seb.patientmanager.service;

import com.seb.patientmanager.data.enums.Gender;
import com.seb.patientmanager.data.model.Patient;
import com.seb.patientmanager.data.repository.PatientRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        super();

        this.patientRepository = patientRepository;
    }

    public List<Patient> getPatients() {
        Patient patient = new Patient();
        patient.setFirstName("Seb");
        patient.setLastName("Vandamme");
        patient.setBirthDate(LocalDate.of(1978,11,24));
        patient.setGender(Gender.MALE);
        patient.setNationalIdentificationNumber("78.11.24-289.25");

        this.patientRepository.save(patient);

        return this.patientRepository.findAll();
    }

    public Patient getPatient(Integer id) {
        Optional<Patient> patient = this.patientRepository.findById(id);

        return patient.orElse(null);
    }

    public Patient savePatient(Patient patient) {
        return this.patientRepository.save(patient);
    }

    public void deletePatient(Integer id) {
        Patient patient = this.getPatient(id);

        if (patient != null) {
            this.patientRepository.delete(patient);
        }
    }
}
