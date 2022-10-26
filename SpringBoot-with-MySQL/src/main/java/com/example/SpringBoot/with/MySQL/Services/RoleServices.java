package com.example.SpringBoot.with.MySQL.Services;

import com.example.SpringBoot.with.MySQL.Entities.Role;
import com.example.SpringBoot.with.MySQL.Entities.UserDetails;
import com.example.SpringBoot.with.MySQL.Repositories.RoleRepositories;
import com.example.SpringBoot.with.MySQL.Repositories.UserDetailsRepositories;
import com.example.SpringBoot.with.MySQL.Responses.usersResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;



@Component
public class RoleServices {

    @Autowired
    RoleRepositories RoleRepo;

    public usersResponses ajouter (Role role) {
        RoleRepo.save(role);
        return new usersResponses("Role posted successfully !!!");
    }

    public List<Role> getAll () {

        return RoleRepo.findAll();
    }

    public Role getOne (int idRole) {
        return RoleRepo.findById(idRole).orElse(null);
    }

    public usersResponses supprimer (int idRole) {
        RoleRepo.deleteById(idRole);
        return new usersResponses("Role deleted successfully !!!");
    }

    public  usersResponses modifier (int idRole , Role role){
        role.setId(idRole);
        RoleRepo.save(role);
        return new usersResponses("Role updates successfully !!!");

    }
}
