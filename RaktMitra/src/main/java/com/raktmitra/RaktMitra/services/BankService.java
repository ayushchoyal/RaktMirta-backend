package com.raktmitra.RaktMitra.services;

import com.raktmitra.RaktMitra.entity.Bank;
import com.raktmitra.RaktMitra.repository.BankRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {
    private final BankRepo bankRepo;
    public BankService(BankRepo bankRepo){
        this.bankRepo=bankRepo;
    }

    public Bank saveBank(Bank bank){
        return bankRepo.save(bank);
    }

    public List<Bank>getAllBanks(){
        return bankRepo.findAll();
    }



}
