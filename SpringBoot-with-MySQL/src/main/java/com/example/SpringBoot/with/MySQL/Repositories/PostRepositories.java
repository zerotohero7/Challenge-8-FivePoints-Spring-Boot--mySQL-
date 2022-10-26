package com.example.SpringBoot.with.MySQL.Repositories;

import com.example.SpringBoot.with.MySQL.Entities.Post;
import com.example.SpringBoot.with.MySQL.Entities.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepositories extends CrudRepository<Post,Integer> {

    @Override
    List<Post> findAll();
}