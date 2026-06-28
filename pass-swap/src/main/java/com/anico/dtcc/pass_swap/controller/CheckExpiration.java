package com.anico.dtcc.pass_swap.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.anico.dtcc.pass_swap.dto.UserRequest;
import com.anico.dtcc.pass_swap.service.PasswordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class CheckExpiration {
    
    private final PasswordService passwordService; 
    //creating the object this way is Spring managed - used with constructor 
    // ^Spring creates object and is aware as opposed to me doing it manurally: PasswordService passwordService = new PasswordService()
    //Constructor injection is preferred instead of using annotaitons for fields like @Autowired - we also don;t need it in modern Spring since Spring automatically injects it

    public CheckExpiration(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    //method used to check how many days are left till password expires
    @PostMapping("/check-expiration")
    public String checkExpiration(@RequestBody UserRequest userRequest) {
        return passwordService.checkExpiration(userRequest);
    }
    
}
