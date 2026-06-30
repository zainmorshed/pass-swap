package com.anico.dtcc.pass_swap.dto;


//this class will be used with the newPassResponse to update password
public class NewPassRequest {
    String userName;
    String newPassword;
    
    public NewPassRequest(String userName, String newPassword) {
        this.userName = userName;
        this.newPassword = newPassword;
    }

    public NewPassRequest(){}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    
}
