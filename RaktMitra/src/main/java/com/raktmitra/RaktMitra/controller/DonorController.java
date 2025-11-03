package com.raktmitra.RaktMitra.controller;

import java.util.List;

import com.raktmitra.RaktMitra.dto.DonorDto;
import com.raktmitra.RaktMitra.repository.DonorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.raktmitra.RaktMitra.entity.Donor;
import com.raktmitra.RaktMitra.services.DonorService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://rakt-mitra-blood-donation.vercel.app"
}, allowCredentials = "true")
public class DonorController {
    @Autowired
    private final DonorService donorService;
    public DonorController(DonorService donorService) {
        this.donorService = donorService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerDonor(@RequestBody Donor donor) {
        try {
            Donor saved = donorService.registerDonor(donor);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error registering donor: " + e.getMessage());
        }
    }
    @GetMapping("/donor")
    public List<Donor> getAllDonors() {
        return donorService.getAllDonors();
    }

    @GetMapping("/donor/{id}")
    public ResponseEntity<Donor>getDonarById(@PathVariable Long id){
        return donorService.getDonorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}
