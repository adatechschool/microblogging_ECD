// package com.microblogging.backend.controllers;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import com.microblogging.backend.services.SearchService;

// import java.util.List;
// import java.util.Map;

// @RestController
// public class SearchController {
//     @Autowired
//     private SearchService searchService;

//     @GetMapping("/api/search")
//     public Map<String, List<?>> search(@RequestParam("q") String query) {
//         return searchService.searchUsersAndPosts(query);
//     }
// }