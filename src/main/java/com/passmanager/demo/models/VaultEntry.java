package com.passmanager.demo.models;

import jakarta.persistence.*;

@Entity
public class VaultEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long hostVault;
    private String serviceName;
    private String username;
    private String email;
    private String password;
    private String recoveryEmail;
    private String recoveryPhone;

    public VaultEntry(){}

    public VaultEntry(Long hostVault, String serviceName, String username, String email, String password, String recoveryEmail, String recoveryPhone){
        this.hostVault = hostVault;
        this.serviceName = serviceName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.recoveryEmail = recoveryEmail;
        this.recoveryPhone = recoveryPhone;
    }

    public void setServiceName(String serviceName){
        this.serviceName = serviceName;
    }

    public String getServiceName(){
        return this.serviceName;
    }

    public Long getId(){
        return this.id;
    }

    public Long getHostVault() {
        return hostVault;
    }

    public void setHostVault(Long hostVault) {
        this.hostVault = hostVault;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRecoveryEmail() {
        return recoveryEmail;
    }

    public void setRecoveryEmail(String recoveryEmail) {
        this.recoveryEmail = recoveryEmail;
    }

    public String getRecoveryPhone() {
        return recoveryPhone;
    }

    public void setRecoveryPhone(String recoveryPhone) {
        this.recoveryPhone = recoveryPhone;
    }
}
