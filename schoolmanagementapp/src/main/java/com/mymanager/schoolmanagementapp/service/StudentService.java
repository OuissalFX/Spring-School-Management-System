package com.mymanager.schoolmanagementapp.service;

import java.util.List;


import com.mymanager.schoolmanagementapp.entity.Student;


public interface StudentService {

	public List<Student> findAll();

	public Student findById(int theId);

	public void save(Student prof);

	public void deleteById(int theId);

	public List<Student> findStudentsByLastName(String lastName);
}
