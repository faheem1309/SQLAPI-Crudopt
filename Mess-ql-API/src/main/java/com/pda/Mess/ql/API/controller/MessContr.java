package com.pda.Mess.ql.API.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pda.Mess.ql.API.model.MessBill;
import com.pda.Mess.ql.API.repository.MessRepo;

@RestController
public class MessContr {
	
	@Autowired
	MessRepo messrepo;
	
    // Add Mess Bill
    @PostMapping("/addBill")
    public String addBill(@RequestBody MessBill bill) {
        // Auto-calculate total = CostPerDay * NumberOfDays
        bill.setTotal(bill.getCpd() * bill.getNod());
        messrepo.save(bill);
        return "Mess Bill Added Successfully";
    }

    // Get All Mess Bills
    @GetMapping("/getBills")
    public List<MessBill> getBills() {
        return (List<MessBill>) messrepo.findAll();
    }

    // Delete Mess Bill
    @DeleteMapping("/delBill/{bid}")
    public String delBill(@PathVariable int bid) {
        messrepo.deleteById(bid);
        return "Mess Bill Deleted Successfully";
    }

    // Update Mess Bill
    @PutMapping("/updBill")
    public String updBill(@RequestBody MessBill bill) {
        MessBill existing = messrepo.findById(bill.getBid()).orElse(null);

        if (existing != null) {
            existing.setSname(bill.getSname());
            existing.setRoomno(bill.getRoomno());
            existing.setDept(bill.getDept());
            existing.setCpd(bill.getCpd());
            existing.setNod(bill.getNod());
            // Auto-calculate again while updating
            existing.setTotal(bill.getCpd() * bill.getNod());
            
            messrepo.save(existing);
            return "Mess Bill Updated Successfully";
        } else {
            return "Bill ID not found!";
        }
    }
}
