package com.filrouge.admingestionplanning.dao.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = false)
    private String username;
    @Column(unique = true)
    private String email;
    private String nom;
    private String prenom;
    private String password;
    private String img;


    @ManyToMany(fetch=FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User(String username, String email, String nom, String prenom, String password, String img) {
        this.username = username;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.img = img;
    }

    public User(Long id, String username, String email, String nom, String prenom, String password, String img, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.img = img;
        this.roles = roles;
    }

    public User(){}

    public User(String username, String email, String nom, String prenom, String password, String img, Set<Role> roles) {
        this.username = username;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
        this.img = img;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPassword(){return password;}

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}