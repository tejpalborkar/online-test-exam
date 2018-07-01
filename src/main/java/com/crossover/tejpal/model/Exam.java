package com.crossover.tejpal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="exam")
public class Exam {

	@Id
	@Column(name="exam_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int examId;
	
	@Column(name="description")
	private String description;
	
	@Column(name="exam_name")
	private String examName;

	public Exam(){
		
	}
	
	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	@Override
	public String toString() {
		return "Exam [examId=" + examId + ", description=" + description + ", examName=" + examName + "]";
	}
	
}
