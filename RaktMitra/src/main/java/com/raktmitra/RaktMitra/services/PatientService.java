package com.raktmitra.RaktMitra.services;

import com.raktmitra.RaktMitra.entity.Donor;
import com.raktmitra.RaktMitra.entity.Patient;
import com.raktmitra.RaktMitra.repository.PatientRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    private final PatientRepo patientRepo;
    public PatientService(PatientRepo patientRepo){
        this.patientRepo=patientRepo;
    }

    public Patient patientRegistration(Patient patient){
        return patientRepo.save(patient);
    }

    public List<Patient> getAllPatients(){
        return patientRepo.findAll();
    }

    public Optional<Patient> getPatientById(Long id) {
        return patientRepo.findById(id);
    }

}
