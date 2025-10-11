package com.raktmitra.RaktMitra.controller;

import com.raktmitra.RaktMitra.entity.Bank;
import com.raktmitra.RaktMitra.services.BankService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:5173")
public class BankController {
    private final BankService bankService;

    public BankController(BankService bankService){
        this.bankService=bankService;
    }

    @PostMapping("/add")
    public ResponseEntity<Bank>addBank(@RequestBody Bank bank){
        Bank savedBank= bankService.saveBank(bank);
        return ResponseEntity.ok(savedBank);
    }

    @GetMapping("/banks")
    public ResponseEntity<List<Bank>>getBanks(){
        return ResponseEntity.ok(bankService.getAllBanks());
    }
}
