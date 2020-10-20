package com.mymanager.schoolmanagementapp.service;

import java.util.List;

import com.mymanager.schoolmanagementapp.entity.ClassLevel;

public interface ClassLevelService {

	public List<ClassLevel> findAll();
	
	public ClassLevel findById(int theId);
	
	public void save(ClassLevel theClass);
	
	public void deleteById(int theId);

	public List<ClassLevel> findClassLevelsByClassName(String classLevelName);
	
	public ClassLevel findByClassName(String classLevelName);

}
