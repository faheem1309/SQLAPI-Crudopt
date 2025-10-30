package com.pda.Mess.ql.API.repository;

import org.springframework.data.repository.CrudRepository;

import com.pda.Mess.ql.API.model.MessBill;

public interface MessRepo extends CrudRepository<MessBill, Integer> {

}
