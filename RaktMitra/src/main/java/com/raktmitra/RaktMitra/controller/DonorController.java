package com.raktmitra.RaktMitra.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.raktmitra.RaktMitra.entity.Donor;
import com.raktmitra.RaktMitra.services.DonorService;

@RestController
@RequestMapping("/user/donor")
@CrossOrigin (origins = "http://localhost:5173")
public class DonorController {
    @Autowired

    private final DonorService donorService;
    public DonorController(DonorService donorService) {
        this.donorService = donorService;
    }

    @PostMapping("register")
    public ResponseEntity<?>registerDonor(@RequestPart("donor") Donor donor,
                                          @RequestPart(value="image",required = false) MultipartFile imageFile){
        try{
            Donor saved = donorService.registerDonor(donor,imageFile);
            return ResponseEntity.ok(saved);
        }catch(Exception e){
            return ResponseEntity.status(500).body("Error: "+ e.getMessage());
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
