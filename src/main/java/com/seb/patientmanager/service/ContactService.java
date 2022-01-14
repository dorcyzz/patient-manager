package com.seb.patientmanager.service;

import com.seb.patientmanager.data.model.Contact;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class ContactService {

    private final JavaMailSender emailSender;

    public ContactService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendEmail(Contact contact) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@seb.com");
        message.setTo(contact.getEmail());
        message.setSubject("Message successfully sent to the Patient Manager team");
        message.setText("Your message has been successfully sent to the Patient Manager team.");

        emailSender.send(message);
    }
    
    public void sendNotificationEmail(Contact contact){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@seb.com");
        message.setTo("sebastien.vandamme@gmail.com");
        message.setSubject("New contact email from " + contact.getName());
        message.setText("New contact email : \n\n" + contact.getMessage());

        emailSender.send(message);
    }
}
