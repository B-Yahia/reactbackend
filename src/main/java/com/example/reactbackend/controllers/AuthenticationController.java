package com.example.reactbackend.controllers;

import com.example.reactbackend.models.Author;
import com.example.reactbackend.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthorService authorService;

    @PostMapping("/register")
    public ResponseEntity<String> registerAuthor(@RequestBody Author author){
        authorService.addAuthor(author);
        return new ResponseEntity<String>("added", HttpStatus.CREATED);
    }
}
