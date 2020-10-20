package com.mymanager.schoolmanagementapp.service;

import org.springframework.stereotype.Service;

import com.mymanager.schoolmanagementapp.dao.CourseProfessorRepository;
import com.mymanager.schoolmanagementapp.entity.CourseProfessor;
import com.mymanager.schoolmanagementapp.entity.CourseProfessorId;

@Service
public class CourseProfessorServiceImpl implements CourseProfessorService {

	private CourseProfessorRepository courseProfessorRepository ;
	
	
	public CourseProfessorServiceImpl(CourseProfessorRepository courseProfessorRepository) {
		this.courseProfessorRepository = courseProfessorRepository;
	}


	@Override
	public void deleteById(CourseProfessorId id) {
		
		courseProfessorRepository.deleteById(id);
	}


	@Override
	public void save(CourseProfessor theCourseProfessor) {
		courseProfessorRepository.save(theCourseProfessor);
		
	}

}
