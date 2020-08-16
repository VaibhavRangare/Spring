package com.vaibhav.springboot.crud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaibhav.springboot.crud.dao.StudentDAO;
import com.vaibhav.springboot.crud.entity.Student;

@RestController
@RequestMapping("/college")
public class StudentRestController {

	private StudentDAO studentDAO;

	@Autowired
	public StudentRestController(StudentDAO theEmployeeDAO) {
		studentDAO = theEmployeeDAO;
	}

	// expose "/employees" and return list of employees
	@GetMapping("/students")
	public List<Student> findAll() {
		return studentDAO.findAll();
	}

}
