package com.shieldme.authentication.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendSimpleMessage(long mailBody) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(String.valueOf(mailBody));
        message.setFrom("noreply@shieldme.com"); // Update to a more professional sender address.
        message.setSubject(String.valueOf(mailBody));
        message.setText(String.valueOf(mailBody));

        javaMailSender.send(message);
    }
}
