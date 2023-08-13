package com.passmanager.demo.controllers;

import com.passmanager.demo.models.VaultEntry;
import com.passmanager.demo.services.VaultEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/vaultEntry", produces = MediaType.APPLICATION_JSON_VALUE)
public class VaultEntryController {

    private final VaultEntryService vaultEntryService;

    @Autowired
    public VaultEntryController(VaultEntryService vaultEntryService){
        this.vaultEntryService = vaultEntryService;
    }

    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createVaultEntry(@RequestBody VaultEntry vaultEntry){
        this.vaultEntryService.createVaultEntry(vaultEntry);
    }

    @GetMapping(path = "/getByEntryId")
    public VaultEntry getEntryById(@RequestBody Long id){
        return this.vaultEntryService.getById(id);
    }

    @GetMapping(path = "/getByVaultId/{id}")
    public List<VaultEntry> getByVaultId(@PathVariable("id") long id){
        return this.vaultEntryService.getEntriesByHostId(id);
    }

    @DeleteMapping(path = "/deleteEntry")
    public void deleteEntry(@RequestBody VaultEntry entry){
        this.vaultEntryService.deleteVaultEntry(entry);
    }

}
