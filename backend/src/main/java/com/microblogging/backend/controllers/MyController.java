package com.microblogging.backend.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microblogging.backend.models.Post;

@RestController
@RequestMapping("/api")
public class MyController {

    @GetMapping("/ihatespringboot/{id}")
    public String iwtkms() {
        
        
        return "jump";
    }
}