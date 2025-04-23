package com.microblogging.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microblogging.backend.models.Post;
import com.microblogging.backend.repositories.PostRepository;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post getPostById(Long id) {
        return postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    public Post updatePost(Long id, Post post) {
        Post existingPost = getPostById(id);
        existingPost.setDescription(post.getDescription());
        return postRepository.save(existingPost);
    }
}
