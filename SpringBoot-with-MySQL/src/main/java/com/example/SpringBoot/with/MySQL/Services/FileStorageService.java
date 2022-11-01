package com.example.SpringBoot.with.MySQL.Services;

import com.example.SpringBoot.with.MySQL.Entities.imageData;
import com.example.SpringBoot.with.MySQL.Exception.FileNotFoundException;
import com.example.SpringBoot.with.MySQL.Repositories.StorageRepositories;
import com.example.SpringBoot.with.MySQL.Util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;


@Service
public class FileStorageService {

    @Autowired
    private StorageRepositories storageRepositories ;


    public String upLoadImage(MultipartFile file) throws IOException {
       imageData imgData =  storageRepositories.save(imageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());

        if (imgData != null){
            return "file upload successfully : " + file.getOriginalFilename();
        }
        return null;
    }




    public ResponseEntity<?> downLoadImage(String fileName){
        Optional<imageData> dbImageData = storageRepositories.findByName(fileName);

        if (!dbImageData.isPresent()){
            throw new FileNotFoundException("image not found");

            /*return new ResponseEntity<>("image not found", HttpStatus.NOT_FOUND);*/

           /* return ResponseEntity.status(HttpStatus.NOT_FOUND).body("kkkk");*/
        }
        byte[] images =ImageUtils.decompressImage(dbImageData.get().getImageData());


        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(images);

    }















}
