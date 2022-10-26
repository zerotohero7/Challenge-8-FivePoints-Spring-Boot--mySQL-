package com.example.SpringBoot.with.MySQL.Services;

import com.example.SpringBoot.with.MySQL.Entities.Post;
import com.example.SpringBoot.with.MySQL.Entities.Role;
import com.example.SpringBoot.with.MySQL.Repositories.PostRepositories;
import com.example.SpringBoot.with.MySQL.Repositories.RoleRepositories;
import com.example.SpringBoot.with.MySQL.Responses.usersResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;



@Component
public class PostServices {

    @Autowired
    PostRepositories PostRepo;

    public usersResponses ajouter (Post post) {
        PostRepo.save(post);
        return new usersResponses("Post posted successfully !!!");
    }

    public List<Post> getAll () {

        return PostRepo.findAll();
    }

    public Post getOne (int idPost) {
        return PostRepo.findById(idPost).orElse(null);
    }

    public usersResponses supprimer (int idPost) {
        PostRepo.deleteById(idPost);
        return new usersResponses("Post deleted successfully !!!");
    }

    public  usersResponses modifier (int idPost , Post post){
        post.setId(idPost);
        PostRepo.save(post);
        return new usersResponses("Post updated successfully !!!");

    }
}
