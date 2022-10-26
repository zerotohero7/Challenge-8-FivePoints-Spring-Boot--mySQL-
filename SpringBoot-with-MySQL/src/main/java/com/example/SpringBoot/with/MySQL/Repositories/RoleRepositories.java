package com.example.SpringBoot.with.MySQL.Repositories;

import com.example.SpringBoot.with.MySQL.Entities.Role;
import com.example.SpringBoot.with.MySQL.Entities.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepositories extends CrudRepository<Role,Integer> {

    @Override
    List<Role> findAll();
}
