package com.mymanager.schoolmanagementapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymanager.schoolmanagementapp.entity.CourseStudent;
import com.mymanager.schoolmanagementapp.entity.CourseStudentId;

public interface CourseStudentRepository extends JpaRepository<CourseStudent, CourseStudentId> {

}
