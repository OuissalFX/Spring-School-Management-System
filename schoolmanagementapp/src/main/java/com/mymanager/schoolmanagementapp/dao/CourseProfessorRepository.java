package com.mymanager.schoolmanagementapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymanager.schoolmanagementapp.entity.CourseProfessor;
import com.mymanager.schoolmanagementapp.entity.CourseProfessorId;

public interface CourseProfessorRepository extends JpaRepository<CourseProfessor, CourseProfessorId> {


}
