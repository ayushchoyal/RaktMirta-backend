package com.raktmitra.RaktMitra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raktmitra.RaktMitra.entity.Donor;

import java.util.Optional;

public interface DonorRepository extends JpaRepository<Donor,Long> {
    Optional<Donor> findByEmail(String email);
}
