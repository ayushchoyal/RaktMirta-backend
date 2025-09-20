package com.raktmitra.RaktMitra.services;

import com.raktmitra.RaktMitra.entity.Donar;
import com.raktmitra.RaktMitra.repository.DonorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonorService {
    private final DonorRepository donorRepository;

    public DonorService(DonorRepository donorRepository)
    {
        this.donorRepository = donorRepository;
    }

    public List<Donar> getAllDonors() {
        return donorRepository.findAll();
    }

    public Optional<Donar> getDonorById(Long id) {
        return donorRepository.findById(id);
    }
}
