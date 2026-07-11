package com.example.myflightdb.Repositories;

import com.example.myflightdb.Entities.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Login,Integer> {
    Optional<Login> findByUsername(String username);
    boolean existsByUsername(String username);
}
