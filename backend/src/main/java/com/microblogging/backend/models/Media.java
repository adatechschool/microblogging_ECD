package com.microblogging.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Medias")
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    
    private String mediaUrl;
    
    @Enumerated(EnumType.STRING)
    private MediaType mediaType;
    
    // Enum pour mediaType
    public enum MediaType {
        IMAGE, VIDEO, AUDIO
    }
    
    // Constructeur vide requis par JPA
    public Media() {
    }
    
    // Constructeur avec paramètres
    public Media(Long id, Post post, String mediaUrl, MediaType mediaType) {
        this.id = id;
        this.post = post;
        this.mediaUrl = mediaUrl;
        this.mediaType = mediaType;
    }
    
    //CONSTRUCTEUR FAUX
    public Media(Long mediaId, String string, String string2, Object object) {
        //TODO Auto-generated constructor stub
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }
}