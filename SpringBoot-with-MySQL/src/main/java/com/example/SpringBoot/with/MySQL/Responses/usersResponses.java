package com.example.SpringBoot.with.MySQL.Responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
public class usersResponses {

    @NonNull
    private String message;

    public usersResponses(String message) {
        this.message = message;
    }
}
