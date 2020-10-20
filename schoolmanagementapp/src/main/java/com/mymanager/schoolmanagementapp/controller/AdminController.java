package com.mymanager.schoolmanagementapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mymanager.schoolmanagementapp.entity.Admin;
import com.mymanager.schoolmanagementapp.service.AdminService;

@Controller
@RequestMapping("/admins")
public class AdminController {

	private AdminService adminService;
	
	public AdminController(AdminService theAdminService) {
		 adminService =  theAdminService;
	}
	
	@GetMapping("/list")
	public String listAdmins(Model theModel) {
		
		List<Admin> theAdmins = adminService.findAll();
		
		theModel.addAttribute("admins",theAdmins);
		
		return "/admins/list-admins";
	}
	
	@GetMapping("/search")
	public String getProfessorbyLastName(@RequestParam("theSearchName") String adminLastName,Model theModel) {
		
		List<Admin> theAdmins =adminService.findAdminsByLastName(adminLastName);
		
		theModel.addAttribute("admins",theAdmins);
		
		
		return "/admins/list-admins";
	}
	
	
	@GetMapping("/showFormForAdd")
	public  String addAdmin(Model theModel) {
		
		Admin theAdmin = new Admin();
		
		theModel.addAttribute("admin", theAdmin);
		return "/admins/admin-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String updateAdmin(@RequestParam("adminId") int theId, Model theModel) {
		
		Admin theAdmin = adminService.findById(theId);
		
		theModel.addAttribute("admin", theAdmin);
		
		return "/admins/admin-form";
	}
	
	@GetMapping("/delete")
	public String deleteAdmin(@RequestParam("adminId") int theId, Model theModel) {
		
		adminService.deleteById(theId);
		
		return "redirect:/admins/list";
	}
	
	
	@PostMapping("/save")
	public String saveAdmin(@ModelAttribute("admin") Admin theAdmin) {
		
		adminService.save(theAdmin);
		
		return "redirect:/admins/list";
	}
	
	
}
