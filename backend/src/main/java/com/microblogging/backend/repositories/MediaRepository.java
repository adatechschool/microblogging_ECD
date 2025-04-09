package com.microblogging.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microblogging.backend.models.Media;

   public interface MediaRepository extends JpaRepository<Media, Long> {
}
    

