package com.mymanager.schoolmanagementapp.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CourseProfessorId implements Serializable{
		
		@Column(name="professor_id")
		private int professorId;
		
		@Column(name="course_id")
		private int courseId;
		
		public CourseProfessorId() {
			
		}

		public CourseProfessorId(int professorId, int courseId) {
			this.professorId = professorId;
			this.courseId = courseId;
		}

		public int getProfessorId() {
			return professorId;
		}

		public void setProfessorId(int professorId) {
			this.professorId = professorId;
		}

		public int getCourseId() {
			return courseId;
		}

		public void setCourseId(int courseId) {
			this.courseId = courseId;
		}
		
		
}
