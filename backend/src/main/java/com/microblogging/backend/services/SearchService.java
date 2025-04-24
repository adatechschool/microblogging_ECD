// package com.microblogging.backend.services;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.microblogging.backend.repositories.UserRepository;
// import com.microblogging.backend.repositories.PostRepository;
// import com.microblogging.backend.models.User;
// import com.microblogging.backend.models.Post;

// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// @Service
// public class SearchService {
//     @Autowired private UserRepository userRepo;
//     @Autowired private PostRepository postRepo;

//     public Map<String, List<?>> searchUsersAndPosts(String q) {
//         String pattern = "%" + q.toLowerCase() + "%";
//         List<User> users = userRepo.findByAliasIgnoreCaseContaining(pattern);
//         List<Post> posts = postRepo.findByDescriptionIgnoreCaseContaining(pattern);
        
//         Map<String, List<?>> result = new HashMap<>();
//         result.put("users", users);
//         result.put("posts", posts);
//         return result;
//     }
// }