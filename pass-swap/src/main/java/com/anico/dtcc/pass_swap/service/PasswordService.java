package com.anico.dtcc.pass_swap.service;

import org.springframework.stereotype.Service;

import com.anico.dtcc.pass_swap.client.DtccClient;
import com.anico.dtcc.pass_swap.dto.PassStatusResponse;
import com.anico.dtcc.pass_swap.dto.UserRequest;

@Service
public class PasswordService {

    private final DtccClient dtccClient;

    public PasswordService(DtccClient dtccClient){
        this.dtccClient = dtccClient;
    }

    PassStatusResponse passStatusResponse = new PassStatusResponse(null, null, null);
    public PassStatusResponse checkExpiration(UserRequest userRequest) {

        passStatusResponse.setUserName(userRequest.getUserName());
        passStatusResponse.setExpirationDate(passStatusResponse.getExpirationDate());
        passStatusResponse.setPasswordStatus(passStatusResponse.getPasswordStatus());        


        return dtccClient.getPasswordExpiration(userRequest);
    }
    
}
