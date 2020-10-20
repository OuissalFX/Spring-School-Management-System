package com.mymanager.schoolmanagementapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mymanager.schoolmanagementapp.entity.ClassLevel;

public interface ClassLevelRepository extends JpaRepository<ClassLevel, Integer> {

	public List<ClassLevel> findAllByClassName(String classLevelName);
	public ClassLevel findByClassName(String classLevelName);

}
