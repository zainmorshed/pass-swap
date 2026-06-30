package com.anico.dtcc.pass_swap.service;

import java.time.LocalDate;
import java.util.Base64;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.anico.dtcc.pass_swap.client.DtccClient;
import com.anico.dtcc.pass_swap.dto.NewPassRequest;
import com.anico.dtcc.pass_swap.dto.PassStatusResponse;
import com.anico.dtcc.pass_swap.dto.UpdatePassRequest;
import com.anico.dtcc.pass_swap.dto.UserRequest;
import com.anico.dtcc.pass_swap.dto.NewPassRequest;
import com.anico.dtcc.pass_swap.dto.newPassResponse;

@Service
public class PasswordService {

    private final DtccClient dtccClient;

    public PasswordService(DtccClient dtccClient){
        this.dtccClient = dtccClient;
    }

    public String updatePassword(UpdatePassRequest updatePassRequest) {
        dtccClient.setNewPassword(updatePassRequest);
        return "Password successfully updated";
        //return success on conditional?
    }

    public newPassResponse checkExpiration(UserRequest userRequest) {

        //call DTCC
        PassStatusResponse response = dtccClient.getPasswordExpiration(userRequest);
    

        // PassStatusResponse passStatusResponse = new PassStatusResponse();
        LocalDate expirationDate = response.getExpirationDate();

        //response object - handle response from DTCC
        newPassResponse result = new newPassResponse();

        String passStatus = response.getPasswordStatus();

        result.setUserName(response.getUserName());

        if (expirationDate.isEqual(LocalDate.now()) || expirationDate.isBefore(LocalDate.now().plusDays(2))) {
            String newPassword = rotatePassword();
            result.setPassword(newPassword);
            result.setNewExpDate(LocalDate.now().plusMonths(1));
            result.setPasswordStatus(passStatus + "Your new password is: " + newPassword);
            result.setBase64Password(encodePassword(newPassword));

            NewPassRequest newPassRequest = new NewPassRequest();

            newPassRequest.setUserName(result.getUserName());
            newPassRequest.setNewPassword(result.getPassword());

            dtccClient.updatePassword(newPassRequest); //in status include that new password has been reset


        } else {
            result.setPassword("Current password still valid");
            result.setNewExpDate(expirationDate);
            result.setPasswordStatus(response.getPasswordStatus()); 
        }

        return result;
        
    }

    public String encodePassword(String plainTextPassword) {
        // String newPassword = rotatePassword();
        if (plainTextPassword == null) {
            return null;
        }

        return Base64.getEncoder().encodeToString(plainTextPassword.getBytes());
        //convert the text string into bytes, encode it, and convert it back to a string

    }

    
    public String rotatePassword() {
        //generate new password
        String password = UUID.randomUUID().toString().substring(0, 12);
        return password;
    }
    
}
