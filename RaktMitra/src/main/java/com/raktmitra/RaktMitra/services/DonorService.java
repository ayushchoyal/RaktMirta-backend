package com.raktmitra.RaktMitra.services;

import com.raktmitra.RaktMitra.entity.Donor;
import com.raktmitra.RaktMitra.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DonorService {

    @Value("${file.upload-dir}")
    private String uploadDir;
    private final DonorRepository donorRepository;

    public DonorService(DonorRepository donorRepository)
    {
        this.donorRepository = donorRepository;
    }

    public Donor registerDonor(Donor donor, MultipartFile imageFile) throws IOException{
        if(imageFile != null && !imageFile.isEmpty()){
            String fileName = UUID.randomUUID() + "_"+imageFile.getOriginalFilename();
            String filePath = uploadDir+ File.separator+fileName;
            File dir = new File(uploadDir);
            if(!dir.exists()){
                dir.mkdirs();
            }
            imageFile.transferTo(new File(filePath));
            donor.setImageUrl(fileName);
        }
        return donorRepository.save(donor);
    }

    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    public Optional<Donor> getDonorById(Long id) {
        return donorRepository.findById(id);
    }
}
