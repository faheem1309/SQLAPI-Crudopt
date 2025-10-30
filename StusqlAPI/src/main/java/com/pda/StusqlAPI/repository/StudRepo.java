package com.pda.StusqlAPI.repository;

import org.springframework.data.repository.CrudRepository;

import com.pda.StusqlAPI.model.Student;

public interface StudRepo extends CrudRepository<Student, Integer> {

}
