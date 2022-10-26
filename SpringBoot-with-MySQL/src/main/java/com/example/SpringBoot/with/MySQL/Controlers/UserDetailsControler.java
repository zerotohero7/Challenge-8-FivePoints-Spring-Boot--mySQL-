package com.example.SpringBoot.with.MySQL.Controlers;

import com.example.SpringBoot.with.MySQL.Entities.UserDetails;
import com.example.SpringBoot.with.MySQL.Entities.Users;
import com.example.SpringBoot.with.MySQL.Responses.usersResponses;
import com.example.SpringBoot.with.MySQL.Services.UserDetailsServices;
import com.example.SpringBoot.with.MySQL.Services.UsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/userDetails")
public class UserDetailsControler {

    @Autowired
    UserDetailsServices userDetailsServices ;

    @PostMapping(value = "/post")
    public usersResponses postOne (@RequestBody UserDetails userDetails) {
        return userDetailsServices.ajouter(userDetails);
    }

    @GetMapping(value = "/get")
    public List<UserDetails> gettingAll (){
        return userDetailsServices.getAll();
    }

    @GetMapping(value = "/get/{id}")
    public UserDetails gettingOne (@PathVariable("id") int idUserDetails){
        return userDetailsServices.getOne(idUserDetails);
    }

    @DeleteMapping(value = "/delete/{id}")
    public usersResponses deleteOne (@PathVariable("id") int idUserDetails){
        return userDetailsServices.supprimer(idUserDetails);
    }

    @PutMapping(value = "/update/{id}")
    public usersResponses updateOne (@PathVariable("id") int idUserDetails ,@RequestBody UserDetails userDetails){
        return userDetailsServices.modifier(idUserDetails , userDetails);
    }

}
