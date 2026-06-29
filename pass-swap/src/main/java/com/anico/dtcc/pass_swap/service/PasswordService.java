package com.anico.dtcc.pass_swap.service;

import java.time.LocalDate;
import java.util.UUID;

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


    public PassStatusResponse checkExpiration(UserRequest userRequest) {

        //call DTCC
        PassStatusResponse response = dtccClient.getPasswordExpiration(userRequest);
    

        // PassStatusResponse passStatusResponse = new PassStatusResponse();
        LocalDate expirationDate = response.getExpirationDate();

        //response object - handle response from DTCC
        PassStatusResponse result = new PassStatusResponse();

        result.setUserName(response.getUserName());
        result.setExpirationDate(expirationDate);
        result.setPasswordStatus(response.getPasswordStatus());

        if (expirationDate.isEqual(LocalDate.now()) || expirationDate.isBefore(LocalDate.now().plusDays(2))) {
            String newPassword = rotatePassword();
            result.setPassword(newPassword);
        } else {
            result.setPassword("Current password still valid");
        }

        return result;
        
    }

    
    public String rotatePassword() {
        //generate new password
        String password = UUID.randomUUID().toString().substring(0, 12);
        return password;
    }
    
}
