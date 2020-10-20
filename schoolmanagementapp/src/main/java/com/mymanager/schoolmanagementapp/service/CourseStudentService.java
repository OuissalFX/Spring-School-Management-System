package com.mymanager.schoolmanagementapp.service;

import com.mymanager.schoolmanagementapp.entity.CourseStudent;
import com.mymanager.schoolmanagementapp.entity.CourseStudentId;

public interface CourseStudentService {

	public void deleteById(CourseStudentId id);
	public void save(CourseStudent courseStudent);
}
