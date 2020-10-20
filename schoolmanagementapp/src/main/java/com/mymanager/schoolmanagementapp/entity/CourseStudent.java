package com.mymanager.schoolmanagementapp.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="course_student")
public class CourseStudent {

	@EmbeddedId
	private CourseStudentId id;
	
	@Column(name="course_registration_date")
	private String registrationDate;
	
	public CourseStudent() {
		
	}

	public CourseStudent(CourseStudentId id, String registrationDate) {
		this.id = id;
		this.registrationDate = registrationDate;
	}

	public CourseStudentId getId() {
		return id;
	}

	public void setId(CourseStudentId id) {
		this.id = id;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Override
	public String toString() {
		return "CourseStudent [id=" + id + ", registrationDate=" + registrationDate + "]";
	}
	
	
	
	
}
