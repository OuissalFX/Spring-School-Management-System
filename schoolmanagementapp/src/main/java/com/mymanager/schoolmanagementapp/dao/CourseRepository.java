package com.mymanager.schoolmanagementapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymanager.schoolmanagementapp.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

	Course findByCourseName(String courseName);

	List<Course> findAllByCourseName(String courseName);

}
