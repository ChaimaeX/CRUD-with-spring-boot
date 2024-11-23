package com.example.lastapp.reposatry;

import com.example.lastapp.model.Voucher;

import org.springframework.data.jpa.repository.JpaRepository;



public interface VRepos extends JpaRepository<Voucher,Integer>{
    Voucher findByCode(String code);
}