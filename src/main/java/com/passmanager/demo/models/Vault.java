package com.passmanager.demo.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Vault {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    private String name;
    private long ownerId;
    private List<Long> vaultEntries;

    public Vault(){}

    public Vault(String name, long ownerId){}

    public Vault(long id, String name, long ownerId, List<Long> entries){
        this.id = id;
        this.name = name;
        this.ownerId = ownerId;
        this.vaultEntries = entries;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwner(Long ownerId) {
        this.ownerId = ownerId;
    }

    public List<Long> getVaultEntries() {
        return vaultEntries;
    }

    public void setVaultEntries(List<Long> vaultEntries) {
        this.vaultEntries = vaultEntries;
    }

    public void addVaultEntry(Long entryId){
        vaultEntries.add(entryId);
    }
}
