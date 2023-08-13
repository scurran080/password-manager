package com.passmanager.demo.services;

import com.passmanager.demo.PasswordEncoder;
import com.passmanager.demo.models.VaultEntry;
import com.passmanager.demo.repository.VaultEntryRepository;
import com.passmanager.demo.repository.VaultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaultEntryService {

    private final VaultEntryRepository vaultEntryRepository;
    //HIDE THESE LASTER. These are only for testing. Do not use repeating 1's as the password for the sha key generation.
    //Will switch to using the password for the main account to encode the information.
    private final String PASS_SECRET_KEY = "1111111111111111";
    private final String SEC_SECRET_KEY = "1111111111111111";
    private PasswordEncoder encoder;

    @Autowired
    public VaultEntryService(VaultEntryRepository vaultEntryRepository){
        this.vaultEntryRepository = vaultEntryRepository;
        this.encoder = new PasswordEncoder();
    }

    public VaultEntry getById(Long entryId){
        return this.vaultEntryRepository.getEntryById(entryId);
    }

    public List<VaultEntry> getEntriesByHostId(long id){
        List<VaultEntry> results =  this.vaultEntryRepository.getEntriesByHostId(id);
        for(int i = 0; i < results.size(); i++){
            String dehashedEmail = encoder.decrypt(results.get(i).getEmail(), SEC_SECRET_KEY);
            String dehashedPassword = encoder.decrypt(results.get(i).getPassword(), PASS_SECRET_KEY);
            results.get(i).setEmail(dehashedEmail);
            results.get(i).setPassword(dehashedPassword);
        }
        return results;
    }

    public void createVaultEntry(VaultEntry entry){
        String hashedPassword = encoder.encrypt(entry.getPassword(), PASS_SECRET_KEY);
        String hashedEmail = encoder.encrypt(entry.getEmail(), SEC_SECRET_KEY);
        System.out.println("hashed pass: " + hashedEmail + "\nhashed email: " + hashedEmail);
        entry.setEmail(hashedEmail);
        entry.setPassword(hashedPassword);
        this.vaultEntryRepository.save(entry);
    }

    public void deleteVaultEntry(VaultEntry entry){
        this.vaultEntryRepository.delete(entry);
    }
}
