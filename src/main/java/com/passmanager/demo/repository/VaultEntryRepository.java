package com.passmanager.demo.repository;

import com.passmanager.demo.models.VaultEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaultEntryRepository extends JpaRepository<VaultEntry, Long> {

    @Query(value = "SELECT * FROM Vault_Entry WHERE Vault_Entry.id = :id", nativeQuery = true)
    public VaultEntry getEntryById(@Param("id") Long id);

    @Query(value = "SELECT * FROM Vault_Entry WHERE Vault_Entry.host_vault = :id", nativeQuery = true)
    public List<VaultEntry> getEntriesByHostId(@Param("id") long id);

}
