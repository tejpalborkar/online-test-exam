package com.crossover.tejpal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 * 
 * @author 
 *
 */
@Entity
@Table(name = "test")
public class Test {

	@Id
	@Column(name = "test_id")
	private String testid;

	@Column(name = "test_name")
	private String testName;

	@Column(name = "exam_id")
	private int examId;
	
	
	@Column(name = "total_ques")
	private int totalQuestions;
	
	public Test(){
		
	}

	public Test(String testId,String testName, int examId,int totalQuestions) {
		this.testid = testId;
		this.testName = testName;
		this.examId = examId;
		this.totalQuestions = totalQuestions;
	}

	public String getTestid() {
		return testid;
	}

	public void setTestid(String testid) {
		this.testid = testid;
	}

	

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	
	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public int getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	@Override
	public String toString() {
		return "Test [testid=" + testid + ", testName=" + testName + ", examId=" + examId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + examId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Test other = (Test) obj;
		if (examId != other.examId)
			return false;
		if (testName != other.testName)
			return false;
		if (testid != other.testid)
			return false;
		return true;
	}
	
	
}
