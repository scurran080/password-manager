package com.passmanager.demo.repository;

import com.passmanager.demo.models.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long>{

    @Query(value = "SELECT * FROM profile where profile.username = :username", nativeQuery = true)
    Profile getProfileByUsername(@Param("username") String username);

    @Query(value = "SELECT COUNT(u) FROM Profile u WHERE u.username = :username", nativeQuery = true)
    int countUsername(@Param("username") String username);

    @Query(value = "SELECT * FROM Profile", nativeQuery = true)
    List<Profile> getAllProfiles();

}
