package com.mymanager.schoolmanagementapp.service;

import com.mymanager.schoolmanagementapp.entity.CourseProfessor;
import com.mymanager.schoolmanagementapp.entity.CourseProfessorId;

public interface CourseProfessorService {

	void deleteById(CourseProfessorId id);

	void save(CourseProfessor theCourseProfessor);
}
