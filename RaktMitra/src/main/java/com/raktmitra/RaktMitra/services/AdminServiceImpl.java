package com.raktmitra.RaktMitra.services;

import com.raktmitra.RaktMitra.entity.Donor;
import com.raktmitra.RaktMitra.repository.DonorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{
    private final DonorRepository donorRepository;
    public AdminServiceImpl(DonorRepository donorRepository){
        this.donorRepository=donorRepository;
    }
    @Override
    public List<Donor> getAllDonors(){
        return donorRepository.findAll();
    }
}
