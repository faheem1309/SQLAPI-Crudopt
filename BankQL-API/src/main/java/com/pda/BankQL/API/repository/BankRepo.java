package com.pda.BankQL.API.repository;

import org.springframework.data.repository.CrudRepository;

import com.pda.BankQL.API.model.Bank;

public interface BankRepo extends CrudRepository<Bank, Integer> {

}
