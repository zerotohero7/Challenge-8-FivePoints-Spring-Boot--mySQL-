package com.example.SpringBoot.with.MySQL.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class SendMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(){
        System.out.println("Sending Email...");
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("mohamednkaies3@gmail.com");
        mail.setSubject("Testing from Spring Boot");
        mail.setText("Hello World  Spring Boot Email");
        // Send mail with javaMailSender
        javaMailSender.send(mail);
    }

}
