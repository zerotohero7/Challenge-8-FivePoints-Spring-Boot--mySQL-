package com.example.SpringBoot.with.MySQL.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String githubProfileLink;
    private String linkedInProfileLink;

    @OneToOne(mappedBy = "userDetails")
    private Users user;

}
