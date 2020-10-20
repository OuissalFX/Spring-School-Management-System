package com.mymanager.schoolmanagementapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymanager.schoolmanagementapp.dao.ClassLevelRepository;
import com.mymanager.schoolmanagementapp.entity.ClassLevel;

@Service
public class ClassLevelServiceImpl implements ClassLevelService {

	
private ClassLevelRepository classLevelRepository;
	
	@Autowired
	public ClassLevelServiceImpl(ClassLevelRepository theClassLevelRepository) {
		classLevelRepository = theClassLevelRepository;
	}

	@Override
	public List<ClassLevel> findAll() {
		
		return classLevelRepository.findAll();
	}

	@Override
	public ClassLevel findById(int theId) {
		
		Optional <ClassLevel> result = classLevelRepository.findById(theId);
		ClassLevel classLevel = null;
		
		if(result.isPresent()) {
			classLevel = result.get();
		}else {
			throw new RuntimeException("Did not find course level id -  + theId");
		}
		
		return classLevel;
	}

	@Override
	public void save(ClassLevel theClassLevel) {
		
		classLevelRepository.save(theClassLevel);
		
	}

	@Override
	public void deleteById(int theId) {
		
		classLevelRepository.deleteById(theId);
		
	}

	@Override
	public List<ClassLevel> findClassLevelsByClassName(String classLevelName) {
		
		return classLevelRepository.findAllByClassName(classLevelName);
	}

	@Override
	public ClassLevel findByClassName(String classLevelName) {
		
		return classLevelRepository.findByClassName(classLevelName);
	}
	
	
	
}