package com.seb.patientmanager.rest.controller;

import com.seb.patientmanager.data.model.Patient;
import com.seb.patientmanager.service.PatientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
@CrossOrigin
public class PatientRestController {
    private final PatientService patientService;

    public PatientRestController(@Autowired PatientService patientService) {
        super();

        this.patientService = patientService;
    }

    @GetMapping("/all")
    public List<Patient> getPatients() {
        return this.patientService.getPatients();
    }

    @GetMapping
    public Patient getPatient(@RequestParam Integer id) {
        return this.patientService.getPatient(id);
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return this.patientService.savePatient(patient);
    }

    @PutMapping
    public Patient updatePatient(@RequestBody Patient patient) {
        return this.patientService.savePatient(patient);
    }

    @DeleteMapping
    public void deletePatient(@RequestParam Integer id) {
        this.patientService.deletePatient(id);
    }
}
