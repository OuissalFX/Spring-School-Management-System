package com.mymanager.schoolmanagementapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymanager.schoolmanagementapp.dao.AdminRepository;
import com.mymanager.schoolmanagementapp.entity.Admin;

@Service
public class AdminServiceImpl implements AdminService {

	
	private AdminRepository adminRepository;
	
	@Autowired
	public AdminServiceImpl(AdminRepository theAdminRepository) {
		adminRepository = theAdminRepository;
	}
	
	
	@Override
	public List<Admin> findAll() {
				
		return adminRepository.findAll();
	}

	@Override
	public Admin findById(int theId) {
		
		Optional <Admin> result = adminRepository.findById(theId);
		Admin theAdmin= null;
		
		if(result.isPresent()) {
			theAdmin = result.get();
		}else {
			throw new RuntimeException("Did not find employee id -  + theId");
		}
		
		return theAdmin;
		
	}

	@Override
	public void save(Admin theAdmin) {
		
		adminRepository.save(theAdmin);
	}

	@Override
	public void deleteById(int theId) {
		
		adminRepository.deleteById(theId);
	}


	@Override
	public List<Admin> findAdminsByLastName(String adminLastName) {
		
		return adminRepository.findAllByLastName(adminLastName);
	}

}
