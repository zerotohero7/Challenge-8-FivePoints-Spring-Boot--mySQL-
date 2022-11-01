package com.example.SpringBoot.with.MySQL.Repositories;


import com.example.SpringBoot.with.MySQL.Entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepositories extends JpaRepository<Users,Integer> {

    @Override
    List<Users> findAll();

   List<Users>  findByEmail(String addressEmail);

   Boolean existsByEmail(String addressEmail);
   @Query("SELECT COUNT(u) FROM Users u")
     Integer numberOfUsers();




}
