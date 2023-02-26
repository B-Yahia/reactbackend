package com.example.reactbackend.service;

import com.example.reactbackend.models.Author;
import com.example.reactbackend.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Author addAuthor (Author author){
        author.setPassword(passwordEncoder.encode(author.getPassword()));
        return authorRepository.save(author);
    }
}

