package com.example.SpringBoot.with.MySQL.Controlers;

import com.example.SpringBoot.with.MySQL.Entities.Role;
import com.example.SpringBoot.with.MySQL.Entities.Users;
import com.example.SpringBoot.with.MySQL.Responses.usersResponses;
import com.example.SpringBoot.with.MySQL.Services.RoleServices;
import com.example.SpringBoot.with.MySQL.Services.UsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping(value = "/role")
public class RoleControler {

    @Autowired
    RoleServices roleServices ;

    @PostMapping(value = "/post")
    public usersResponses postOne (@RequestBody Role role) {
        return roleServices.ajouter(role);
    }

    @GetMapping(value = "/get")
    public List<Role> gettingAll (){
        return roleServices.getAll();
    }

    @GetMapping(value = "/get/{id}")
    public Role gettingOne (@PathVariable("id") int idRole){
        return roleServices.getOne(idRole);
    }

    @DeleteMapping(value = "/delete/{id}")
    public usersResponses deleteOne (@PathVariable("id") int idRole){
        return roleServices.supprimer(idRole);
    }

    @PutMapping(value = "/update/{id}")
    public usersResponses updateOne (@PathVariable("id") int idRole ,@RequestBody Role role){
        return roleServices.modifier(idRole , role);
    }

}
