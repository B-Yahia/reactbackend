package com.example.reactbackend.security;

import com.example.reactbackend.models.Author;
import com.example.reactbackend.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthorUserDetailsService implements UserDetailsService {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Author> author =authorRepository.findByUsername(username );
        return  author.map(AuthorUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("not found"));
    }
}

