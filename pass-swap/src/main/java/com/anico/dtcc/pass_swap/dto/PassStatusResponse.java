package com.anico.dtcc.pass_swap.dto;

import java.time.LocalDate;

public class PassStatusResponse {
    private String userName;
    private LocalDate expirationDate;
    private String passwordStatus;
    private String password;

    
    public PassStatusResponse(String userName, LocalDate expirationDate, String passwordStatus, String password) {
        this.userName = userName;
        this.expirationDate = expirationDate;
        this.passwordStatus = passwordStatus;
        this.password = password;
    }

    public PassStatusResponse(){}

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public LocalDate getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getPasswordStatus() {
        return passwordStatus;
    }

    public void setPasswordStatus(String passwordStatus) {
        this.passwordStatus = passwordStatus;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
