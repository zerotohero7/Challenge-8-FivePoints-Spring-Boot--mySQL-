package com.example.SpringBoot.with.MySQL.Repositories;


import com.example.SpringBoot.with.MySQL.Entities.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepositories extends CrudRepository<Users,Integer> {

    @Override
    List<Users> findAll();
}
