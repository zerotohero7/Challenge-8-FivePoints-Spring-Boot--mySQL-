package com.example.SpringBoot.with.MySQL.Services;

import com.example.SpringBoot.with.MySQL.Entities.UserDetails;
import com.example.SpringBoot.with.MySQL.Entities.Users;
import com.example.SpringBoot.with.MySQL.Repositories.UserDetailsRepositories;
import com.example.SpringBoot.with.MySQL.Repositories.UsersRepositories;
import com.example.SpringBoot.with.MySQL.Responses.usersResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserDetailsServices {

    @Autowired
    UserDetailsRepositories UserDetailsRepo;

    public usersResponses ajouter (UserDetails userDetails) {
        UserDetailsRepo.save(userDetails);
        return new usersResponses("UserDetails posted successfully !!!");
    }

    public List<UserDetails> getAll () {

        return UserDetailsRepo.findAll();
    }

    public UserDetails getOne (int idUserDetails) {
        return UserDetailsRepo.findById(idUserDetails).orElse(null);
    }

    public usersResponses supprimer (int idUserDetails) {
        UserDetailsRepo.deleteById(idUserDetails);
        return new usersResponses("UserDetails deleted successfully !!!");
    }

    public  usersResponses modifier (int idUserDetails , UserDetails userDetails){
        userDetails.setId(idUserDetails);
        UserDetailsRepo.save(userDetails);
        return new usersResponses("UserDetails updates successfully !!!");

    }
}
