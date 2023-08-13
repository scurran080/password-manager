package com.passmanager.demo.repository;

import com.passmanager.demo.models.Vault;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VaultRepository extends JpaRepository<Vault, Long> {

    @Query(value = "SELECT * FROM Vault WHERE Vault.id = :#{#id}", nativeQuery = true)
    public Vault getVaultById(@Param("id") long id);

    @Query(value = "SELECT * FROM Vault WHERE Vault.owner_id = :#{#ownerId}", nativeQuery = true)
    public List<Vault> getByOwnerId(@Param("ownerId") long ownerId);
}
