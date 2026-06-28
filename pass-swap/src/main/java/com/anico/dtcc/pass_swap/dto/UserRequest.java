package com.anico.dtcc.pass_swap.dto;

public class UserRequest {
    
    private String user;

    public UserRequest(String user) {
        this.user = user;
    }

    public UserRequest(){}

    public String getUser() {
        return user;
    }


    public void setUser(String user){
        this.user = user;
    }

}
