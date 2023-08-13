package com.passmanager.demo.services;

import com.passmanager.demo.models.Vault;
import com.passmanager.demo.repository.VaultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaultService {

    private final VaultRepository vaultRepository;
    @Autowired
    public VaultService(VaultRepository vaultRepository){
        this.vaultRepository = vaultRepository;
    }

    public void createVault(Vault vault){
        this.vaultRepository.save(vault);
    }

    public Vault getVaultById(long id){
        return this.vaultRepository.getVaultById(id);
    }

    public List<Vault> getVaultsByOwnerId(long ownerId){
        return this.vaultRepository.getByOwnerId(ownerId);
    }
    public void deleteVaultById(Long vaultId){
        this.vaultRepository.deleteById(vaultId);
    }
}
