package com.mymanager.schoolmanagementapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mymanager.schoolmanagementapp.entity.Professor;
import com.mymanager.schoolmanagementapp.service.ProfessorService;

@Controller
@RequestMapping("/professors")
public class ProfessorController {

	private ProfessorService professorService;
	
	
	public ProfessorController(ProfessorService theProfService) {
		
		professorService = theProfService;
		
	}
	
	
	@GetMapping("/list")
	public String listProfessors(Model theModel) {
		
	 List<Professor> theProfessors = professorService.findAll();
	 theModel.addAttribute("professors", theProfessors);
	 
	 return "/professors/list-professors";
	}
	
	@GetMapping("/search")
	public String getProfessorbyLastName(@RequestParam("theSearchName") String professorLastName,Model theModel) {
		
		List<Professor> theProfessors = professorService.findProfessorsByLastName(professorLastName);
		
		theModel.addAttribute("professors",theProfessors);
		
		
		return "/professors/list-professors";
	}
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Professor theProfessor = new Professor();
		theModel.addAttribute("professor", theProfessor);
		return "professors/professor-form";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("professorId") int theId, Model theModel) {
		
		Professor theProfessor = professorService.findById(theId);
		theModel.addAttribute("professor", theProfessor);
		
		return "professors/professor-form";
		
	}
	
	@PostMapping("/save")
	public String saveProfessor(@ModelAttribute("professor") Professor theProfessor) {
		
		professorService.save(theProfessor);
		
		return "redirect:/professors/list";
		
	}
	
	
	@GetMapping("/delete")
	public String delete(@RequestParam("professorId") int theId) {
		
		professorService.deleteById(theId);
		
		return "redirect:/professors/list";
	}
	
	@GetMapping("/showCourses")
	public String showCourses(@RequestParam("professorId") int theId, Model theModel) {
		
		Professor theProfessor = professorService.findById(theId);
		
		theModel.addAttribute("professor",theProfessor);
		
		
		return "/professors/professor-list-courses";
	}
	
}
