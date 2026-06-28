package com.anico.dtcc.pass_swap.dto;

public class UserRequest {
    
    private String userName;

    public UserRequest(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName){
        this.userName = userName;
    }

}
