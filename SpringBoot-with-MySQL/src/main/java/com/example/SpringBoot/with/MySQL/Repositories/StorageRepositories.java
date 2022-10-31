package com.example.SpringBoot.with.MySQL.Repositories;

import com.example.SpringBoot.with.MySQL.Entities.imageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StorageRepositories extends JpaRepository<imageData, Long> {


    Optional<imageData> findByName(String fileName);
}
