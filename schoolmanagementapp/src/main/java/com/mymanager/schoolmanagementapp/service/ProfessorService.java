package com.mymanager.schoolmanagementapp.service;

import java.util.List;

import com.mymanager.schoolmanagementapp.entity.Professor;


public interface ProfessorService {

	public List<Professor> findAll();

	public Professor findById(int theId);

	public void save(Professor prof);

	public void deleteById(int theId);

	public List<Professor> findProfessorsByLastName(String lastName);

}
