package com.passmanager.demo.services;

import com.passmanager.demo.models.Profile;
import com.passmanager.demo.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;
    private BCryptPasswordEncoder encoder;

    @Autowired
    public ProfileService(ProfileRepository profileRepository){
        this.profileRepository = profileRepository;
        this.encoder = new BCryptPasswordEncoder();
    }

    /**
     *Need to add an encryption step for the password.
     * Not sure if I should add it in the Service layer or Controller Layer.
     */

    private boolean isUsernameAvailable(String username){
        int exists = this.profileRepository.countUsername(username);
        if(exists > 0){
            return false;
        }
        return true;
    }

    public void createUser(Profile profile){
        if(isUsernameAvailable(profile.getUsername())){
            profile.setPassword(encoder.encode(profile.getPassword()));
            this.profileRepository.save(profile);
        }
         //not necessary but will be later once I add in responses, and change from void
    }
    public Profile getProfileById(Long id){
        return this.profileRepository.findById(id).get();
    }
    public Profile getProfileByUsername(String username){
        System.out.println(username);
        Profile user = this.profileRepository.getProfileByUsername(username);
        return user;
    }
    public List<Profile> getAllProfiles(){
        return this.profileRepository.getAllProfiles();
    }

    public void deleteUser(long userId){
        this.profileRepository.deleteById(userId);
    }

    public Profile userSignIn(String username, String password){
        Profile profile = this.profileRepository.getProfileByUsername(username);
        if(encoder.matches(password, profile.getPassword())){}
        if(profile == null){
            return null;
        }
        if(encoder.matches(password, profile.getPassword())){
            return profile;
        }
        return null;
    }

}
