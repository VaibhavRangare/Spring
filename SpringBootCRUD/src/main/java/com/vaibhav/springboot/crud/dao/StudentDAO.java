package com.vaibhav.springboot.crud.dao;

import java.util.List;

import com.vaibhav.springboot.crud.entity.Student;

public interface StudentDAO {

	public List<Student> findAll();

}
