package com.seb.patientmanager.rest.controller;

import com.seb.patientmanager.data.model.Contact;
import com.seb.patientmanager.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
@CrossOrigin
public class ContactRestController {
    private final ContactService contactService;

    public ContactRestController(@Autowired ContactService contactService) {
        super();

        this.contactService = contactService;
    }

    @PostMapping
    public void manageNewContactMessage(@RequestBody Contact contact) {
        this.contactService.sendEmail(contact);

        this.contactService.sendNotificationEmail(contact);
    }
}
