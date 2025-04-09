package com.microblogging.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microblogging.backend.models.Post;

   public interface PostRepository extends JpaRepository<Post, Long> {
}
    

