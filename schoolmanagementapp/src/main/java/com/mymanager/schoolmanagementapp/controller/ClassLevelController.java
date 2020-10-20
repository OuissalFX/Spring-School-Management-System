package com.mymanager.schoolmanagementapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.mymanager.schoolmanagementapp.entity.ClassLevel;
import com.mymanager.schoolmanagementapp.entity.Student;
import com.mymanager.schoolmanagementapp.service.ClassLevelService;



@Controller
@RequestMapping("/classLevels")
public class ClassLevelController {

    private ClassLevelService classLevelService;
	
	public ClassLevelController(ClassLevelService theClassLevelService) {
		 classLevelService=  theClassLevelService;
	}
	
	@GetMapping("/list")
	public String listClassLevels(Model theModel) {
		
		List<ClassLevel> theClassLevels = classLevelService.findAll();
		
		theModel.addAttribute("classLevels",theClassLevels);
		
		return "/class-level/list-class-Levels";
	}
	
	@GetMapping("/search")
	public String getProfessorbyLastName(@RequestParam("theSearchName") String classLevelName,Model theModel) {
		
		List<ClassLevel> theClassLevels =classLevelService.findClassLevelsByClassName(classLevelName);
		
		theModel.addAttribute("classLevels",theClassLevels);
		
		
		return "/class-level/list-class-Levels";
	}
	
	@GetMapping("/showFormForAdd")
	public String addClassLevel(Model theModel) {
		
		ClassLevel theClassLevel = new ClassLevel();
		
		theModel.addAttribute("classLevel", theClassLevel);
		return "/class-level/class-level-form";
	}
	
	@GetMapping("/showStudents")
	public String showStudents(@RequestParam("classLevelId") int theId, Model theModel) {
		
		ClassLevel theClassLevel = classLevelService.findById(theId);
		List<Student> studentsList = theClassLevel.getStudents();
		
		theModel.addAttribute("students", studentsList);
		
		return "/class-level/class-level-students";
	}
	
	@GetMapping("/showFormForUpdate")
	public String updateClassLevel(@RequestParam("classLevelId") int theId, Model theModel) {
		
		ClassLevel theClassLevel = classLevelService.findById(theId);
		
		theModel.addAttribute("classLevel", theClassLevel);
		
		return "/class-level/class-level-form";
	}
	
	@GetMapping("/delete")
	public String deleteClassLevel(@RequestParam("classLevelId") int theId, Model theModel) {
		
		classLevelService.deleteById(theId);
		
		return "redirect:/classLevels/list";
	}
	
	@PostMapping("/save")
	public String saveClassLevel(@ModelAttribute("classLevel") ClassLevel theClassLevel) {
		
		classLevelService.save(theClassLevel);
		return "redirect:/classLevels/list";
	}
}
