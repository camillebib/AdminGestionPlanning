package com.ajc.projet.dao.entities;

import jakarta.persistence.*;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int type; //type 0 = User, type 1 = Admin, type 2 = SuperAdmin
    @Id
    private String pseudo;
    @Id
    private String email;
    private String nom;
    private String prenom;
    private String password;
    private String img;
}
