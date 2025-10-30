package com.pda.StusqlAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pda.StusqlAPI.model.Student;
import com.pda.StusqlAPI.repository.StudRepo;

@RestController
public class StudContr {
	
	@Autowired
	StudRepo studrepo;
	
	 @PostMapping("/addStud")
	    public String addStud(@RequestBody Student student) {
	        studrepo.save(student);
	        return "Student Added Successfully";
	    }

	    @GetMapping("/getStud")
	    public List<Student> getStud() {
	        return (List<Student>) studrepo.findAll();
	    }

	    @DeleteMapping("/delStud/{sid}")
	    public String delStud(@PathVariable int sid) {
	        studrepo.deleteById(sid);
	        return "Student Deleted Successfully";
	    }

	    @PutMapping("/updStud")
	    public String updStud(@RequestBody Student student) {
	        Student st = studrepo.findById(student.getSid()).get();
	        st.setSname(student.getSname());
	        st.setDept(student.getDept());
	        studrepo.save(st);
	        return "Student Updated Successfully";
	    }
}