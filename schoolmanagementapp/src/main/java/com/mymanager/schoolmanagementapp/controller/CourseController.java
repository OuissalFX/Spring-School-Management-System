package com.mymanager.schoolmanagementapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mymanager.schoolmanagementapp.entity.Course;
import com.mymanager.schoolmanagementapp.service.CourseService;


@Controller
@RequestMapping("/courses")
public class CourseController {

	private CourseService courseService;

	public CourseController(CourseService courseService) {
		
		this.courseService = courseService;
	
	}
	
	@GetMapping("/list")
	public String listCourses(Model theModel) {
		
		List<Course> theCourses = courseService.findAll();
		
		theModel.addAttribute("courses",theCourses);
		
		return "/courses/list-courses";
	}
	
	@GetMapping("/showProfessors")
	public String showProfessors(  @RequestParam("courseId") int theId, Model theModel) {
		
		Course theCourse = courseService.findById(theId);
		theModel.addAttribute("course",theCourse);
	
		
		return "/courses/course-list-professors";
	}
	
	@GetMapping("/showStudents")
	public String showStudents(  @RequestParam("courseId") int theId, Model theModel) {
		
		Course theCourse = courseService.findById(theId);
		theModel.addAttribute("course",theCourse);
	
		
		return "/courses/list-course-students";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Course theCourse = new Course();
	
		theModel.addAttribute("course", theCourse);
		
		return "/courses/course-form";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("courseId") int theId, Model theModel) {
			
		Course theCourse = courseService.findById(theId);
		
		theModel.addAttribute("course", theCourse);
		
		return "/courses/course-form";
		
	}
	
	@PostMapping("/save")
	public String saveCourse(@ModelAttribute("course") Course theCourse) {
		
		courseService.save(theCourse);
		
		// prevent duplicate submissions?
		return "redirect:/courses/list";
		
	}
	
	@GetMapping("/search")
	public String getCourseByName(@RequestParam("theSearchName") String courseName,Model theModel) {
		
		List <Course> theCourses= courseService.findAllByCourseName(courseName);
		
		theModel.addAttribute("courses",theCourses);
		
		
		return "/courses/list-courses";
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("courseId") int theId) {
		
		courseService.deleteById(theId);
		
		return "redirect:/courses/list";
	}
	
	
	
	
}
