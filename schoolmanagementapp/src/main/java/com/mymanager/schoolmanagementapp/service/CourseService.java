package com.mymanager.schoolmanagementapp.service;

import java.util.List;

import com.mymanager.schoolmanagementapp.entity.Course;



public interface CourseService {

	public List<Course> findAll();
	
	public Course findById(int theId);
	
	public void save(Course theCourse);
	
	public void deleteById(int theId);
	
	public Course findByCourseName(String courseName);

	public List<Course> findAllByCourseName(String courseName);

	
}
