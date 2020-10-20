package com.mymanager.schoolmanagementapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymanager.schoolmanagementapp.dao.ProfessorRepository;
import com.mymanager.schoolmanagementapp.entity.Professor;

@Service
public class ProfessorServiceImpl implements ProfessorService {

	private ProfessorRepository professorRepository;
	
	@Autowired
	public ProfessorServiceImpl( ProfessorRepository theProfessorRepository) {
		professorRepository = theProfessorRepository;
	}
	
	
	@Override
	public List<Professor> findAll(){
		return professorRepository.findAllByOrderByLastNameAsc();
	}
	
	@Override
	public Professor findById(int theId) {
		
		Optional <Professor> result = professorRepository.findById(theId);
		Professor prof = null;
		
		if(result.isPresent()) {
			prof = result.get();
		}else {
			throw new RuntimeException("Did not find employee id -  + theId");
		}
		
		return prof;
	}
	
	
	@Override
	public void save(Professor prof) {
		professorRepository.save(prof);
	}
	
	@Override
	public void deleteById(int theId) {
		professorRepository.deleteById(theId);
	}


	@Override
	public List<Professor> findProfessorsByLastName(String lastName) {
		
		
		return professorRepository.findAllByLastName(lastName);
	}
}
