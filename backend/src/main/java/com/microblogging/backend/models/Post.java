package com.microblogging.backend.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    private String description;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    // Constructeur vide requis par JPA
    public Post() {
    }
    
    // Constructeur avec paramètres
    public Post(Long id, User user, String description, LocalDateTime createdAt) {
        this.id = id;
        this.user = user;
        this.description = description;
        this.createdAt = createdAt;
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}