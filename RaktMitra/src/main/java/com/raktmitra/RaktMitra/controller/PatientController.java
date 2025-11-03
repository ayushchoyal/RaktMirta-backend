package com.raktmitra.RaktMitra.controller;


import com.raktmitra.RaktMitra.entity.Patient;
import com.raktmitra.RaktMitra.services.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = {
        "http://localhost:5173",
        "https://rakt-mitra-blood-donation.vercel.app"
}, allowCredentials = "true")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService){
        this.patientService=patientService;
    }

    @PostMapping("/patient/register")
    public ResponseEntity<?>registerPatient(@RequestBody Patient patient){
        try{
            Patient saved = patientService.patientRegistration(patient);
            return ResponseEntity.ok(saved);
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Failed to register");
        }
    }
    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }
}
