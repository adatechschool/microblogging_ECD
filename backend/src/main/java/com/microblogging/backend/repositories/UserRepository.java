package com.microblogging.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.microblogging.backend.models.User;

   public interface UserRepository extends JpaRepository<User, Long> {
}
