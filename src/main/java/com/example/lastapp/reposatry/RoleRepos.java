package com.example.lastapp.reposatry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lastapp.model.Role;

public interface RoleRepos extends JpaRepository<Role, Integer> {
    
}
