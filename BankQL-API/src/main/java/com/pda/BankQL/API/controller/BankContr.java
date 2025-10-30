package com.pda.BankQL.API.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pda.BankQL.API.model.Bank;
import com.pda.BankQL.API.repository.BankRepo;

@RestController
public class BankContr {
	
	@Autowired
	BankRepo bankrepo;
	
	@PostMapping("/addBank")
    public String addBank(@RequestBody Bank bank) {
        bankrepo.save(bank);
        return "Bank Record Added Successfully";
    }

    @GetMapping("/getBanks")
    public List<Bank> getBanks() {
        return (List<Bank>) bankrepo.findAll();
    }

    @DeleteMapping("/delBank/{bid}")
    public String delBank(@PathVariable int bid) {
        bankrepo.deleteById(bid);
        return "Bank Record Deleted Successfully";
    }

    @PutMapping("/updBank")
    public String updBank(@RequestBody Bank bank) {
        Bank existing = bankrepo.findById(bank.getBid()).get();
        existing.setAname(bank.getAname());
        existing.setBname(bank.getBname());
        existing.setBal(bank.getBal());
        bankrepo.save(existing);
        return "Bank Record Updated Successfully";
    }
}