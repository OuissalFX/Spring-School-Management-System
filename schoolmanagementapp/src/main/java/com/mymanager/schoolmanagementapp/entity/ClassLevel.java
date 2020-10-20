package com.mymanager.schoolmanagementapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="class")
public class ClassLevel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="class_name")
	private String className;
	
	@OneToMany(mappedBy="classLevel",
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH,CascadeType.REFRESH})
	private List<Student> students;
	
	
	public ClassLevel() {
		
	}


	public ClassLevel(String className) {
		this.className = className;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getClassName() {
		return className;
	}


	public void setClassName(String className) {
		this.className = className;
	}


	public List<Student> getStudents() {
		return students;
	}


	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void add(Student student) {
		if(students == null) {
			students = new ArrayList<>();
		}
		
		students.add(student);
		
		student.setClassLevel(this);
	}

	@Override
	public String toString() {
		return "ClassGrade [id=" + id + ", clasName=" + className + "]";
	}
	
	
}
