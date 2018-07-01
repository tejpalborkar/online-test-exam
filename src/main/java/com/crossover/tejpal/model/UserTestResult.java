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
@Table(name="user_test_result")
public class UserTestResult {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="user_id")
	private int userId;

	@Column(name="question_id")
	private int questionId;

	@Column(name="received_ans_index")
	private int receivedAnsIndex;
	
	@Column(name="test_id")
	private String testId;
	
	public UserTestResult(){
		
	}
	
	
	
	public UserTestResult( int userId, int questionId, int receivedAnsIndex) {
		super();
		this.userId = userId;
		this.questionId = questionId;
		this.receivedAnsIndex = receivedAnsIndex;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getReceivedAnsIndex() {
		return receivedAnsIndex;
	}
	public void setReceivedAnsIndex(int receivedAnsIndex) {
		this.receivedAnsIndex = receivedAnsIndex;
	}
	
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	@Override
	public String toString() {
		return "UserTestResult [id=" + id + ", userId=" + userId + ", questionId=" + questionId + ", receivedAnsIndex="
				+ receivedAnsIndex + ", testId=" + testId + "]";
	}
	
	
}


