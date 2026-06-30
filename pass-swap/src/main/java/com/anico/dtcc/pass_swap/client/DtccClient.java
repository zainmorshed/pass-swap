package com.anico.dtcc.pass_swap.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.anico.dtcc.pass_swap.dto.UserRequest;
import com.anico.dtcc.pass_swap.dto.NewPassRequest;
import com.anico.dtcc.pass_swap.dto.PassStatusResponse;
import com.anico.dtcc.pass_swap.dto.UpdatePassRequest;

@Service
public class DtccClient {
    
    private final RestTemplate restTemplate = new RestTemplate();

    public PassStatusResponse
     getPasswordExpiration(UserRequest userRequest) {

        String url = "http://localhost:8081/password-expiration";

        return restTemplate.postForObject(url, userRequest, PassStatusResponse.class);
        //^this means:
        // make a GET request
        //to that url
        //expect a String response - String.class tells Spring that the response coming back should be treated as a String
        //.class is native to Java - every type in Java has a Class object - it represents the type itself, not a value
        //^Sprign doesn't know what the API returns so you tell it: String.class -> "Convert the HTTP response into a String"
    }

    public String updatePassword(NewPassRequest newPassword) {

        String url = "http://localhost:8081/reset-password";

        return restTemplate.postForObject(url, newPassword, String.class);
    }

    //use for manually updating to a new password
    public String setNewPassword(UpdatePassRequest updatedPassword) {

        String url = "http://localhost:8081/change-password";

        return restTemplate.postForObject(url, updatedPassword, String.class);
    }
}
