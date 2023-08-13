package com.passmanager.demo.controllers;

import com.passmanager.demo.dtos.LogInDto;
import com.passmanager.demo.models.Profile;
import com.passmanager.demo.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import javax.crypto.Cipher;


@RestController
@RequestMapping(path = "api/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final ProfileService profileService;

    @Autowired
    public UserController(ProfileService profileService){
        this.profileService = profileService;
    }
    
    @PostMapping(path = "/create", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void createUser(@RequestBody Profile profile){
        System.out.println(profile.toString());
        this.profileService.createUser(profile);
    }
    
    @GetMapping(path = "/get/{id}")
    public Profile getUserById(@PathVariable("id") long id){
        return this.profileService.getProfileById(id);
    }

    @GetMapping(path = "/username/{username}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Profile getUserByUsername(@PathVariable("username") String username){
        System.out.println("Request String: " + username);
        return this.profileService.getProfileByUsername(username);
    }

    @GetMapping(path = "/signin")
    public Profile signIn(@RequestBody LogInDto logInInfo){
        System.out.println("username: " + logInInfo.username + "\npassword: " + logInInfo.password);
        return this.profileService.userSignIn(logInInfo.username, logInInfo.password);
    }

    @GetMapping(path = "/getAll")
    public List<Profile> getAllUsers(){
        return this.profileService.getAllProfiles();
    }

}
