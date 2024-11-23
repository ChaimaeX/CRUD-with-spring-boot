package com.example.lastapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.lastapp.model.Voucher;
import com.example.lastapp.reposatry.VRepos;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class VoucherController2 {
    @Autowired

    private VRepos repos;

    @RequestMapping("/")
    public String hello(){
        return "index";
    }

    @GetMapping("/showCreateVoucher")
    public String showCreateVoucher() {
        return "createVoucher";
    }

    @PostMapping("/saveVoucher")
    public String save(Voucher voucher) {
        //TODO: process POST request
        repos.save(voucher);
        return "createResponse";
    }

    @GetMapping("/showGetVoucher")
    public String showGetVoucher() {
        return "getVoucher";
    }
    

    @PostMapping("/getVoucher")
    public ModelAndView getVoucher(String code) {
        //TODO: process POST request
        ModelAndView mav = new ModelAndView("voucherDetails");
        System.out.println(code);
        mav.addObject(repos.findByCode(code));
        return mav;
    }
    


    
    

    
}
