package com.example.SpringBoot.with.MySQL.Controlers;


import com.example.SpringBoot.with.MySQL.Responses.usersResponses;
import com.example.SpringBoot.with.MySQL.Services.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/send")
public class SendMailController {

    @Autowired
    SendMailService sendMailService;



    @PostMapping(value="simple")
    public ResponseEntity<usersResponses> sendEmail()
    {
        this.sendMailService.sendEmail();
        return ResponseEntity.ok().body(new usersResponses("Mail send successfully!"));
    }
}
