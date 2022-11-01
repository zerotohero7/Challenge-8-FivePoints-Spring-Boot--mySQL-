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

    @GetMapping(value = "/get/size")
    public Integer gettingAllNumber (){
        return UsersService.getAllNumber();
    }

    @GetMapping(value = "/get/id/{id}")
    public Users gettingOne (@PathVariable("id") int idUser){
        return UsersService.getOne(idUser);
    }

    @GetMapping(value = "/get/existed/id/{id}")
    public Boolean existsWithId (@PathVariable("id") int idUser){
        return UsersService.existsByID(idUser);
    }

    @GetMapping(value="/get/email/{email}")
    public List<Users> gettingEmail(@PathVariable("email") String addressEmail){
        return UsersService.getByEmail(addressEmail);
    }

    @GetMapping(value = "/get/existed/email/{email}")
    public Boolean existsWithId (@PathVariable("email") String emailUser){
        return UsersService.existsByEMAIL(emailUser);
    }

    @GetMapping(value = "/get/count")
    public Integer countingUsers(){
        return UsersService.countUsers();
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
