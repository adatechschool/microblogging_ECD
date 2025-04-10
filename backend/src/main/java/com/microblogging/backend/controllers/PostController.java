package com.microblogging.backend.controllers;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microblogging.backend.models.Post;
import com.microblogging.backend.services.PostService;

@RestController
@RequestMapping("/api")
public class PostController {

    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    
    @GetMapping("/posts/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/posts")
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }
}