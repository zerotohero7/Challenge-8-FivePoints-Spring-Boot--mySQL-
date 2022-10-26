package com.example.SpringBoot.with.MySQL.Repositories;

import com.example.SpringBoot.with.MySQL.Entities.UserDetails;
import com.example.SpringBoot.with.MySQL.Entities.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDetailsRepositories extends CrudRepository<UserDetails,Integer> {

    @Override
    List<UserDetails> findAll();
}
