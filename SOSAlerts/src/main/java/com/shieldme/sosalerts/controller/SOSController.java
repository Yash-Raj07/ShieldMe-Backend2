package com.shieldme.sosalerts.controller;


import com.shieldme.sosalerts.model.UserContact;
import com.shieldme.sosalerts.repository.UserContactRepository;
import com.shieldme.sosalerts.service.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/sos")
@CrossOrigin("*")
public class SOSController {

    private final UserContactRepository contactRepository;
    private final EmailService emailService;
    public SOSController(UserContactRepository contactRepository, EmailService emailService) {
        this.contactRepository = contactRepository;
        this.emailService = emailService;
    }

    @PostMapping("/alert")
    public ResponseEntity<String> sendSOSAlert(
            @RequestParam String userId,
            @RequestParam String username,
            @RequestParam double latitude,
            @RequestParam double longitude
    ) {
        try {
            Optional<UserContact> userContact = contactRepository.findByUserId(userId);

            if (userContact.isPresent()) {
                UserContact contact = userContact.get();
                String googleMapsLink = String.format("https://www.google.com/maps?q=%s,%s", latitude, longitude);

                emailService.sendAlertEmails(contact.getContacts(), googleMapsLink, username);
                return ResponseEntity.ok("SOS alerts sent successfully!");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to send SOS alerts: " + e.getMessage());
        }
    }
}

