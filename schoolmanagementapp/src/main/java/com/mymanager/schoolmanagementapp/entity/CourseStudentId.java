package com.mymanager.schoolmanagementapp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CourseStudentId implements Serializable {

	@Column(name="student_id")
	private int studentId;
	
	@Column(name="course_id")
	private int courseId;
	
	public CourseStudentId() {
		
	}

	public CourseStudentId(int studentId, int courseId) {
		this.studentId = studentId;
		this.courseId = courseId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	@Override
	public String toString() {
		return "CourseStudentId [studentId=" + studentId + ", courseId=" + courseId + "]";
	}
	
	
	
	
}
