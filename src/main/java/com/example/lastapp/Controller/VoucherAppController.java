package com.example.lastapp.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lastapp.model.Voucher;
import com.example.lastapp.reposatry.VRepos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("voucherapi")
public class VoucherAppController {
    
    @Autowired
    VRepos repo;

    @PostMapping("/vouchers")
    public Voucher create(@RequestBody Voucher voucher) {
        //TODO: process POST request
        
        return repo.save(voucher);
    }

    @GetMapping("/vouchers/{code}")
    public Voucher getVoucher(@PathVariable("code") String code){
        return repo.findByCode(code);
    }
    
}
    

