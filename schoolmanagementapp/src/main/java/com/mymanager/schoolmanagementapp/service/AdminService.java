package com.mymanager.schoolmanagementapp.service;

import java.util.List;

import com.mymanager.schoolmanagementapp.entity.Admin;

public interface AdminService {

	public List<Admin> findAll();
	
	public Admin findById(int theId);
	
	public void save(Admin theAdmin);
	
	public void deleteById(int theId);

	public List<Admin> findAdminsByLastName(String adminLastName);
}
