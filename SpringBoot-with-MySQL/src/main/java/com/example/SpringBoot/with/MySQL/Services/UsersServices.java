package com.example.SpringBoot.with.MySQL.Services;

import com.example.SpringBoot.with.MySQL.Entities.Users;
import com.example.SpringBoot.with.MySQL.Repositories.UsersRepositories;
import com.example.SpringBoot.with.MySQL.Responses.usersResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class UsersServices {

    @Autowired
    UsersRepositories UsersRepo;

    public usersResponses ajouter (Users users) {
        UsersRepo.save(users);
        return new usersResponses("User posted successfully !!!");
    }

    public List<Users> getAll () {

        return UsersRepo.findAll();
    }

    public Integer getAllNumber () {

        return UsersRepo.findAll().size();
    }


    public Users getOne (int idUser) {
        return UsersRepo.findById(idUser).orElse(null);
    }

    public Boolean existsByID (int idUser){
        return UsersRepo.existsById(idUser);
    }

    public  List<Users> getByEmail(String addressEmail){
        return UsersRepo.findByEmail(addressEmail);
    }

    public Boolean existsByEMAIL (String emailUser){
        return UsersRepo.existsByEmail(emailUser);
    }

    public Integer countUsers(){
        return  UsersRepo.numberOfUsers();
    }

    public usersResponses supprimer (int idUser) {
        UsersRepo.deleteById(idUser);
        return new usersResponses("User deleted successfully !!!");
    }

    public  usersResponses modifier (int idUser , Users user){
        user.setId(idUser);
        UsersRepo.save(user);
        return new usersResponses("User updates successfully !!!");

    }
 }
