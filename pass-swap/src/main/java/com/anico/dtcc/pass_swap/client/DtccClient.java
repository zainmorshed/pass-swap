package com.anico.dtcc.pass_swap.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DtccClient {
    
    private final RestTemplate restTemplate = new RestTemplate();

    public String getPasswordExpiration(String user) {

        String url = "http://localhost:8081/password-expiration";

        return restTemplate.postForObject(url, user, String.class);
        //^this means:
        // make a GET request
        //to that url
        //expect a String response - String.class tells Spring that the response coming back should be treated as a String
        //.class is native to Java - every type in Java has a Class object - it represents the type itself, not a value
        //^Sprign doesn't know what the API returns so you tell it: String.class -> "Convert the HTTP response into a String"
    }
}
