package com.mymanager.schoolmanagementapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymanager.schoolmanagementapp.entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {


	// method to sort by last name
	
	public List<Professor> findAllByOrderByLastNameAsc();

	public List<Professor> findAllByLastName(String lastName);
}
