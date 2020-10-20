package com.mymanager.schoolmanagementapp.service;

import org.springframework.stereotype.Service;

import com.mymanager.schoolmanagementapp.dao.CourseStudentRepository;
import com.mymanager.schoolmanagementapp.entity.CourseStudent;
import com.mymanager.schoolmanagementapp.entity.CourseStudentId;

@Service
public class CourseStudentServiceImpl implements CourseStudentService {

	CourseStudentRepository courseStudentRepository;
	
	public CourseStudentServiceImpl(CourseStudentRepository courseStudentRepository) {
		
		this.courseStudentRepository = courseStudentRepository;
	}

	@Override
	public void deleteById(CourseStudentId id) {
		courseStudentRepository.deleteById(id);
	}

	@Override
	public void save(CourseStudent courseStudent) {
		
		courseStudentRepository.save(courseStudent);
	}

}
