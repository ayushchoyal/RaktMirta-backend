package com.raktmitra.RaktMitra.controller;


import com.raktmitra.RaktMitra.entity.Donor;
import com.raktmitra.RaktMitra.services.AdminService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class AdminController {
    private final AdminService adminService;
    public AdminController(AdminService adminService){
        this.adminService=adminService;
    }
    @GetMapping("/admin/donors")
    public List<Donor> getAllDonors(){
        return adminService.getAllDonors();
    }
}
