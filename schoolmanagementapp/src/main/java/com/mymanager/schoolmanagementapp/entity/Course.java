package com.mymanager.schoolmanagementapp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="course_name")
	private String courseName;
	
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH,CascadeType.REFRESH})
	@JoinTable(
			name="course_professor",
			joinColumns=@JoinColumn(name="course_id"),
			inverseJoinColumns=@JoinColumn(name="professor_id")
			)
	private List<Professor> professors;
	
	
	@ManyToMany(fetch = FetchType.LAZY,
			cascade= {CascadeType.PERSIST, CascadeType.MERGE,
					CascadeType.DETACH,CascadeType.REFRESH})
	@JoinTable(
			name="course_student",
			joinColumns=@JoinColumn(name="course_id"),
			inverseJoinColumns=@JoinColumn(name="student_id")
			)
	private List<Student> students;
	
	
	public Course() {
		
	}


	public Course(String courseName) {
		this.courseName = courseName;
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<Professor> getProfessors() {
		return professors;
	}


	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}

	public void addProfessor(Professor theProfessor) {
		if(professors == null) {
			professors = new ArrayList<>();
		}
		
		professors.add(theProfessor);
	}


	public List<Student> getStudents() {
		return students;
	}


	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void addStudent(Student theStudent) {
		if(students == null) {
			students = new ArrayList<>();
		}
		
		students.add(theStudent);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + "]";
	}
	
	
	
	
}
