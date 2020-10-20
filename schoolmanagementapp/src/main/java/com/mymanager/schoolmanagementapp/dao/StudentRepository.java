package com.mymanager.schoolmanagementapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymanager.schoolmanagementapp.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	
	public List<Student> findAllByOrderByLastNameAsc();

	public List<Student> findAllByLastName(String lastName);
}
