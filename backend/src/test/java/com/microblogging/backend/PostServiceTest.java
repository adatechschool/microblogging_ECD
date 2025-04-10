package com.microblogging.backend;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.microblogging.backend.models.Post;
import com.microblogging.backend.repositories.PostRepository;
import com.microblogging.backend.services.PostService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {
    
    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostService postService;

    @Test
    void testGetPostById() {
        Long postId = 1L;
        Post fakePost = new Post(postId, null, "Fake description", null); // Assuming User and LocalDateTime are handled elsewhere
        // Mocking the behavior of the repository to return the fake post when findById is called
        Mockito.when(postRepository.findById(postId)).thenReturn(Optional.of(fakePost));

        Post result = postService.getPostById(postId);

        Assertions.assertThat(result).isEqualTo(fakePost);
    }

    @Test
    void testGetAllPosts() {
        // Assuming you have a method to create a list of fake posts
        List<Post> fakePosts = List.of(new Post(1L, null, "Fake description 1", null),
                                        new Post(2L, null, "Fake description 2", null));
        Mockito.when(postRepository.findAll()).thenReturn(fakePosts);

        List<Post> result = postService.getAllPosts();

        Assertions.assertThat(result).isEqualTo(fakePosts);
    }

    @Test
    void testCreatePost() {
        Post newPost = new Post(null, null, "New post description", null); // Assuming User and LocalDateTime are handled elsewhere
        Post savedPost = new Post(1L, null, "New post description", null); // Mocked saved post with ID
        Mockito.when(postRepository.save(newPost)).thenReturn(savedPost);

        Post result = postService.createPost(newPost);

        Assertions.assertThat(result).isEqualTo(savedPost);
    }

    @Test
    void testDeletePost() {
        Long postId = 1L;
        // No need to return anything from the repository for delete operation
        Mockito.doNothing().when(postRepository).deleteById(postId);

        // Call the method to test
        postService.deletePost(postId);

        // Verify that the deleteById method was called with the correct ID
        Mockito.verify(postRepository, Mockito.times(1)).deleteById(postId);
    }

    @Test
    void testUpdatePost() {
        Long postId = 1L;
        Post existingPost = new Post(postId, null, "Old description", null); // Assuming User and LocalDateTime are handled elsewhere
        Post updatedPost = new Post(postId, null, "Updated description", null); // Mocked updated post

        Mockito.when(postRepository.findById(postId)).thenReturn(Optional.of(existingPost));
        Mockito.when(postRepository.save(existingPost)).thenReturn(updatedPost);

        Post result = postService.updatePost(postId, updatedPost);

        Assertions.assertThat(result).isEqualTo(updatedPost);
        Assertions.assertThat(existingPost.getDescription()).isEqualTo("Updated description");
    }
}
