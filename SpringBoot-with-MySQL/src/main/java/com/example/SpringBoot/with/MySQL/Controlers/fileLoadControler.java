package com.example.SpringBoot.with.MySQL.Controlers;

import com.example.SpringBoot.with.MySQL.Services.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
public class fileLoadControler {

    @Autowired
    private FileStorageService fileStorageService;


    @PostMapping
    public ResponseEntity<?> upLoadImg (@RequestParam("image") MultipartFile file) throws IOException {
        String upLoadImg = fileStorageService.upLoadImage(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(upLoadImg);

    }

    @GetMapping("/{fileName}")
    public ResponseEntity<?> downLoadImg (@PathVariable String  fileName){

      return fileStorageService.downLoadImage(fileName);
    }














}
