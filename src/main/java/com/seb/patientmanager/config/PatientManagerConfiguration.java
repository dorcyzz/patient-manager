package com.seb.patientmanager.config;

import com.seb.patientmanager.data.repository.AddressRepository;
import com.seb.patientmanager.data.repository.HistoryRepository;
import com.seb.patientmanager.data.repository.NoteRepository;
import com.seb.patientmanager.data.repository.PatientRepository;
import com.seb.patientmanager.service.AddressService;
import com.seb.patientmanager.service.ContactService;
import com.seb.patientmanager.service.HistoryService;
import com.seb.patientmanager.service.NoteService;
import com.seb.patientmanager.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class PatientManagerConfiguration {

    @Bean
    public PatientService patientService(@Autowired PatientRepository patientRepository) {
        return new PatientService(patientRepository);
    }

    @Bean
    public AddressService addressService(@Autowired AddressRepository addressRepository) {
        return new AddressService(addressRepository);
    }

    @Bean
    public NoteService noteService(@Autowired NoteRepository noteRepository) {
        return new NoteService(noteRepository);
    }

    @Bean
    public HistoryService historyService(@Autowired HistoryRepository historyRepository) {
        return new HistoryService(historyRepository);
    }

    @Bean
    public ContactService contactService(@Autowired JavaMailSender emailSender) {
        return new ContactService(emailSender);
    }
}
