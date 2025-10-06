package com.raktmitra.RaktMitra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raktmitra.RaktMitra.entity.Donor;

public interface DonorRepository extends JpaRepository<Donor,Long> {
    Donor findByEmail(String email);
}
