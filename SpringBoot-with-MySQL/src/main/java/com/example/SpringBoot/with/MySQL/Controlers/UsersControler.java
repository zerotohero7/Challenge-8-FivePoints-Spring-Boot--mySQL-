package com.example.SpringBoot.with.MySQL.Controlers;


import com.example.SpringBoot.with.MySQL.Entities.Users;
import com.example.SpringBoot.with.MySQL.Responses.usersResponses;
import com.example.SpringBoot.with.MySQL.Services.UsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UsersControler {

    @Autowired
    UsersServices UsersService ;

    @PostMapping(value = "/post")
    public usersResponses postOne (@RequestBody Users users) {
        return UsersService.ajouter(users);
    }

    @GetMapping(value = "/get")
    public List<Users> gettingAll (){
       return UsersService.getAll();
    }

    @GetMapping(value = "/get/{id}")
    public Users gettingOne (@PathVariable("id") int idUser){
        return UsersService.getOne(idUser);
    }

    @DeleteMapping(value = "/delete/{id}")
    public usersResponses deleteOne (@PathVariable("id") int idUser){
       return UsersService.supprimer(idUser);
    }

    @PutMapping(value = "/update/{id}")
    public usersResponses updateOne (@PathVariable("id") int idUser ,@RequestBody Users user){
        return UsersService.modifier(idUser , user);
    }

}
