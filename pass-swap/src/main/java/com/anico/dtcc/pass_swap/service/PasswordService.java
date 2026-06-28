package com.anico.dtcc.pass_swap.service;

import org.springframework.stereotype.Service;

import com.anico.dtcc.pass_swap.client.DtccClient;

@Service
public class PasswordService {

    private final DtccClient dtccClient;

    public PasswordService(DtccClient dtccClient){
        this.dtccClient = dtccClient;
    }

    public String checkExpiration(String user) {
        return dtccClient.getPasswordExpiration(user);
    }
    
}
