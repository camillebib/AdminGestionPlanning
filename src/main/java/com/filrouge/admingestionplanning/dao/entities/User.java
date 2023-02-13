package com.filrouge.admingestionplanning.dao.entities;

import jakarta.persistence.*;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int type; //type 0 = User, type 1 = Admin, type 2 = SuperAdmin
    private String pseudo;
    private String email;
    private String nom;
    private String prenom;
    private String password;
    private String img;

    public User(int type, String pseudo, String email, String nom, String prenom, String password, String img) {
        this.type = type;
        this.pseudo = pseudo;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.img = img;
    }

    public User(){}

    public User(String name, String firstName, String email, String password, String image, String pseudo, String type) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}