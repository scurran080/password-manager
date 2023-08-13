package com.passmanager.demo.controllers;

import com.passmanager.demo.models.Vault;
import com.passmanager.demo.models.VaultEntry;
import com.passmanager.demo.services.VaultEntryService;
import com.passmanager.demo.services.VaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/vault", produces = MediaType.APPLICATION_JSON_VALUE)
public class VaultController {

    private final VaultService vaultService;
    private final VaultEntryService vaultEntryService;

    @Autowired
    public VaultController(VaultService vaultService, VaultEntryService vaultEntryService){
        this.vaultService = vaultService;
        this.vaultEntryService = vaultEntryService;
    }

    @PostMapping(path = "/createVault", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void createVault(@RequestBody Vault vault){
        this.vaultService.createVault(vault);
    }

    @GetMapping(path ="/vaultId/{id}")
    public Vault getVaultById(@PathVariable("id") long id){
        return this.vaultService.getVaultById(id);
    }

    @GetMapping(path = "/getByOwnerId/{ownerId}")
    public List<Vault> getByOwnerId(@PathVariable("ownerId") long ownderId){
        return this.vaultService.getVaultsByOwnerId(ownderId);
    }

    @DeleteMapping(path = "/delete")
    public void deleteVaultById(long id){
        this.vaultService.deleteVaultById(id);
    }
}
