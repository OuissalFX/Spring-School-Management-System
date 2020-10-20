package com.mymanager.schoolmanagementapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mymanager.schoolmanagementapp.entity.CourseProfessor;
import com.mymanager.schoolmanagementapp.entity.CourseProfessorId;
import com.mymanager.schoolmanagementapp.service.CourseProfessorService;
import com.mymanager.schoolmanagementapp.service.CourseService;
import com.mymanager.schoolmanagementapp.service.ProfessorService;

@Controller
@RequestMapping("/coursesProfessors")
public class CourseProfessorController {
	
	private CourseProfessorService courseProfessorService;
	private ProfessorService professorService;
	private CourseService courseService;
	
	
	public CourseProfessorController(CourseProfessorService courseProfessorService, ProfessorService professorService,
			CourseService courseService) {
		this.courseProfessorService = courseProfessorService;
		this.professorService = professorService;
		this.courseService = courseService;
	}

	

	// adding a course to a professor's courses
	@GetMapping("/showFormForAddCourse")
	public String showFormForAddCourse(@RequestParam("professorId") int professorId,Model theModel) {
		
		
		theModel.addAttribute("id", professorId);
		theModel.addAttribute("courses", courseService.findAll());
		
		return "/courses-professors/professor-course-form";
	}

	// adding a professor to a course's professors
	@GetMapping("/showFormForAddProfessor")
	public String showFormForAdd(@RequestParam("courseId") int courseId,Model theModel) {
		
		
		theModel.addAttribute("id", courseId);
		theModel.addAttribute("professors", professorService.findAll());
		
		return "/courses-professors/course-professor-form";
	}

	@PostMapping("/save")
	public String save(@RequestParam("courseId") int courseId,
			@RequestParam("professorId") int professorId,
			@RequestParam("numberOfHours") int numberOfHours) {
		
		CourseProfessorId id = new CourseProfessorId(professorId,courseId);
		CourseProfessor theCourseProfessor = new CourseProfessor(id,numberOfHours);
		courseProfessorService.save(theCourseProfessor);
		return "redirect:/courses/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("professorId") int professorId,@RequestParam("courseId") int courseId) {
		
		CourseProfessorId id = new CourseProfessorId(professorId, courseId);
		
		courseProfessorService.deleteById(id);
		
		return "redirect:/courses/list";
	}
}
