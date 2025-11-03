package com.raktmitra.RaktMitra.services;

import com.raktmitra.RaktMitra.entity.Donor;
import com.raktmitra.RaktMitra.entity.Patient;
import com.raktmitra.RaktMitra.repository.DonorRepository;
import com.raktmitra.RaktMitra.repository.PatientRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService{
    private final DonorRepository donorRepository;
    private final PatientRepo patientRepo;
    public AdminServiceImpl(DonorRepository donorRepository,PatientRepo patientRepo){
        this.donorRepository=donorRepository;
        this.patientRepo=patientRepo;
    }
    @Override
    public List<Donor> getAllDonors(){
        return donorRepository.findAll();
    }

    public List<Patient> getAllPatients(){
        return patientRepo.findAll();
    }
}
