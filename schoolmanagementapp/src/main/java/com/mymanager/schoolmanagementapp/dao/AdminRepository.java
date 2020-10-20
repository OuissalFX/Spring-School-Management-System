package com.mymanager.schoolmanagementapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mymanager.schoolmanagementapp.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	public List<Admin> findAllByOrderByLastNameAsc();

	public List<Admin> findAllByLastName(String adminLastName);
}
