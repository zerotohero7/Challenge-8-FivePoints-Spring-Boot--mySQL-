package com.example.SpringBoot.with.MySQL.Responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
public class usersResponses {

    private String message;

    public usersResponses(String message) {
        this.message = message;
    }
}
