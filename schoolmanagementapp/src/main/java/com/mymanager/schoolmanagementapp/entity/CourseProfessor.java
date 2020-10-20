package com.mymanager.schoolmanagementapp.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="course_professor")
public class CourseProfessor {


	@EmbeddedId
	private CourseProfessorId id;
	
	@Column(name="number_of_hours")
	private int numberOfHours;

	public CourseProfessor() {
		
	}

	public CourseProfessor(CourseProfessorId id, int nbr_of_hours) {
		this.id = id;
		this.numberOfHours = nbr_of_hours;
	}

	public CourseProfessorId getId() {
		return id;
	}

	public void setId(CourseProfessorId id) {
		this.id = id;
	}

	public int getNbr_of_hours() {
		return numberOfHours;
	}

	public void setNbr_of_hours(int nbr_of_hours) {
		this.numberOfHours = nbr_of_hours;
	}
	
	
	
}
	
