package com.anico.dtcc.pass_swap.dto;

import java.time.LocalDate;

public class newPassResponse {
    private String userName;
    private String password;
    private LocalDate newExpDate;
    private String passwordStatus;
    private String base64Password;

    public newPassResponse(String userName, String password, LocalDate newExpDate, String passwordStatus, String base64Password) {
        this.userName = userName;
        this.password = password;
        this.newExpDate = newExpDate;
        this.passwordStatus = passwordStatus;
        this.base64Password = base64Password;
    }

    public String getBase64Password() {
        return base64Password;
    }

    public void setBase64Password(String base64Password) {
        this.base64Password = base64Password;
    }

    public newPassResponse(){}

    public LocalDate getNewExpDate() {
        return newExpDate;
    }

    public void setNewExpDate(LocalDate newExpDate) {
        this.newExpDate = newExpDate;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPasswordStatus() {
        return passwordStatus;
    }
    public void setPasswordStatus(String passwordStatus) {
        this.passwordStatus = passwordStatus;
    }

    
}
