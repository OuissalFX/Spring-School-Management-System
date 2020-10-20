package com.mymanager.schoolmanagementapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mymanager.schoolmanagementapp.dao.CourseRepository;
import com.mymanager.schoolmanagementapp.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {

	private CourseRepository courseRepository;
	
	public CourseServiceImpl(CourseRepository theCourseRepository) {
		courseRepository = theCourseRepository;
	}
	@Override
	public List<Course> findAll() {
		
		return courseRepository.findAll();
	}

	@Override
	public Course findById(int theId) {
		
		Optional <Course> result = courseRepository.findById(theId);
		Course course = null;
		
		if(result.isPresent()) {
			course = result.get();
		}else {
			throw new RuntimeException("Did not find course id -  + theId");
		}
		return course;
	}

	@Override
	public void save(Course theCourse) {
		
		courseRepository.save(theCourse);

	}

	@Override
	public void deleteById(int theId) {
		
		courseRepository.deleteById(theId);
	}
	@Override
	public Course findByCourseName(String courseName) {
		
		return courseRepository.findByCourseName(courseName);
	}
	@Override
	public List<Course> findAllByCourseName(String courseName) {
		
		return courseRepository.findAllByCourseName(courseName);
	}

}
