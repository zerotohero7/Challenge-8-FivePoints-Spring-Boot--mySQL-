package com.example.SpringBoot.with.MySQL.Controlers;

import com.example.SpringBoot.with.MySQL.Entities.Post;
import com.example.SpringBoot.with.MySQL.Entities.Role;
import com.example.SpringBoot.with.MySQL.Responses.usersResponses;
import com.example.SpringBoot.with.MySQL.Services.PostServices;
import com.example.SpringBoot.with.MySQL.Services.RoleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping(value = "/post")
public class PostControler {

    @Autowired
    PostServices postServices ;

    @PostMapping(value = "/post")
    public usersResponses postOne (@RequestBody Post post) {
        return postServices.ajouter(post);
    }

    @GetMapping(value = "/get")
    public List<Post> gettingAll (){
        return postServices.getAll();
    }

    @GetMapping(value = "/get/{id}")
    public Post gettingOne (@PathVariable("id") int idPost){
        return postServices.getOne(idPost);
    }

    @DeleteMapping(value = "/delete/{id}")
    public usersResponses deleteOne (@PathVariable("id") int idPost){
        return postServices.supprimer(idPost);
    }

    @PutMapping(value = "/update/{id}")
    public usersResponses updateOne (@PathVariable("id") int idPost ,@RequestBody Post post){
        return postServices.modifier(idPost , post);
    }

}
