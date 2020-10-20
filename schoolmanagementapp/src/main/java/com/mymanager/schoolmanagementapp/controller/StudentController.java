package com.mymanager.schoolmanagementapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mymanager.schoolmanagementapp.entity.Student;
import com.mymanager.schoolmanagementapp.service.ClassLevelService;
import com.mymanager.schoolmanagementapp.service.StudentService;


@Controller
@RequestMapping("/students")
public class StudentController {


	private StudentService studentService;
	private ClassLevelService classLevelService;

	
	
	
	public StudentController(StudentService studentService, ClassLevelService classLevelService) {
		this.studentService = studentService;
		this.classLevelService = classLevelService;
	}

	@GetMapping("/list")
	public String listStudents(Model theModel) {
		
	 List<Student> theStudents = studentService.findAll();
	 
	 theModel.addAttribute("students", theStudents);
	 
	 return "/students/list-students";
	}
	
	@GetMapping("/search")
	public String getProfessorbyLastName(@RequestParam("theSearchName") String studentLastName,Model theModel) {
		
		List<Student> theStudents = studentService.findStudentsByLastName(studentLastName);
		
		theModel.addAttribute("students",theStudents);
		
		
		return "/students/list-students";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd( Model theModel) {
		
		Student theStudent = new Student();
		
		theModel.addAttribute("student", theStudent);
		theModel.addAttribute("classLevels", classLevelService.findAll());
		
		return "/students/student-form";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {
		
		
		
		Student theStudent = studentService.findById(theId);
		theModel.addAttribute("classLevels", classLevelService.findAll());
		
		
		theModel.addAttribute("student", theStudent);
		
		return "/students/student-form";
		
	}
	
	@PostMapping("/save")
	public String saveProfessor(@RequestParam("classLevelName") String classLevelName,
			@ModelAttribute("student") Student theStudent) {
		
		theStudent.setClassLevel(classLevelService.findByClassName(classLevelName));
		studentService.save(theStudent);
		
		// prevent duplicate submissions?
		return "redirect:/students/list";
		
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {
		
		studentService.deleteById(theId);
		
		return "redirect:/students/list";
	}
	
	@GetMapping("/showCourses")
	public String showCourses(@RequestParam("studentId") int theId, Model theModel) {
		
		Student theStudent = studentService.findById(theId);
		
		theModel.addAttribute("student",theStudent);
		
		
		return "/students/list-student-courses";
	}
	
}
