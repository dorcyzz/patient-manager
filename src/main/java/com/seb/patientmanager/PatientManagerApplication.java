package com.seb.patientmanager;

import com.seb.patientmanager.data.model.Patient;
import com.seb.patientmanager.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatientManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientManagerApplication.class, args);
    }
}
