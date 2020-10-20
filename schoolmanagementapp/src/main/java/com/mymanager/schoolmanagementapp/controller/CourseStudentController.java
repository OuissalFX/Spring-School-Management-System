package com.mymanager.schoolmanagementapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mymanager.schoolmanagementapp.entity.CourseStudent;
import com.mymanager.schoolmanagementapp.entity.CourseStudentId;
import com.mymanager.schoolmanagementapp.service.CourseService;
import com.mymanager.schoolmanagementapp.service.CourseStudentService;

@Controller
@RequestMapping("coursesStudents")
public class CourseStudentController {

	private CourseStudentService courseStudentService;
	private CourseService courseService;

	public CourseStudentController(CourseStudentService courseStudentService, CourseService courseService) { 
		this.courseStudentService = courseStudentService;
		this.courseService = courseService;
	}




	@GetMapping("showFormForAddCourse")
	public String addCourse(@RequestParam("studentId") int studentId,
							Model theModel) {
		
		theModel.addAttribute("studentId", studentId);
		theModel.addAttribute("courses", courseService.findAll());
		return "/courses-students/student-course-form";
		
	}
	
	
	@PostMapping("save")
	public String save(@RequestParam("studentId") int studentId,
					@RequestParam("courseId") int courseId,
					@RequestParam("registrationDate") String registrationDate,
							Model theModel) {
		
		CourseStudentId id = new CourseStudentId(studentId, courseId);
		courseStudentService.save(new CourseStudent(id, registrationDate));
		
		return "redirect:/students/list";
		
		
	}
	
}
