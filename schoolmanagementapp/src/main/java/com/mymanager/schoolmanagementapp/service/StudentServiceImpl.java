package com.mymanager.schoolmanagementapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymanager.schoolmanagementapp.dao.StudentRepository;
import com.mymanager.schoolmanagementapp.entity.Student;


@Service
public class StudentServiceImpl implements StudentService{

  private StudentRepository studentRepository;
	
	@Autowired
	public StudentServiceImpl( StudentRepository theStudentRepository) {
		studentRepository = theStudentRepository;
	}
	
	
	@Override
	public List<Student> findAll(){
		return studentRepository.findAllByOrderByLastNameAsc();
	}
	
	@Override
	public Student findById(int theId) {
		
		Optional <Student> result = studentRepository.findById(theId);
		Student student = null;
		
		if(result.isPresent()) {
			student = result.get();
		}else {
			throw new RuntimeException("Did not find employee id -  + theId");
		}
		
		return student;
	}
	
	
	@Override
	public void save(Student student) {
		studentRepository.save(student);
	}
	
	@Override
	public void deleteById(int theId) {
		studentRepository.deleteById(theId);
	}


	@Override
	public List<Student> findStudentsByLastName(String lastName) {
		
		
		return studentRepository.findAllByLastName(lastName);
	}
}
