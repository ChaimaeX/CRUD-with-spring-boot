package com.example.lastapp.reposatry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lastapp.model.User;

public interface UserRepos extends JpaRepository<User,Integer> {
    User findByEmail(String email);
    
}
