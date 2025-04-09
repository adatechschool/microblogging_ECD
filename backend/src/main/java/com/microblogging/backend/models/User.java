package com.microblogging.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String alias;
    private String email;
    private String password;
    
    @Column(name = "profilPictureUrl")
    private String profilPictureUrl;
    
    private String biography;
    
    // Constructeur vide requis par JPA
    public User() {
    }
    
    // Constructeur utilisé dans vos tests
    public User(Long id, String alias, String email, String password) {
        this.id = id;
        this.alias = alias;
        this.email = email;
        this.password = password;
    }
    
    // Constructeur complet
    public User(Long id, String alias, String email, String password, String profilPictureUrl, String biography) {
        this.id = id;
        this.alias = alias;
        this.email = email;
        this.password = password;
        this.profilPictureUrl = profilPictureUrl;
        this.biography = biography;
    }
    
    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getProfilPictureUrl() {
        return profilPictureUrl;
    }

    public void setProfilPictureUrl(String profilPictureUrl) {
        this.profilPictureUrl = profilPictureUrl;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}