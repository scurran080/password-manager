package com.passmanager.demo.models;

import jakarta.persistence.*;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(unique = true, name = "username")
    private String username;
    private String password;

    public Profile(){

    }

    public Profile(String username, String password){
        this.username = username;
        this.password = password;
    }

    public Profile(long id, String username, String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public void setId(Long id){
        this.id = id;
    }

    public long getId(){
        return this.id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return "username: " + username + "\npassword: " + password;
    }

}
