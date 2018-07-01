package com.crossover.tejpal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 * 
 * @author pankaj
 *
 */
@Entity
@Table(name = "user_test_score")
public class UserTestScore {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "test_id")
	private int testId;

	@Column(name = "score")
	private int score;

	public UserTestScore() {
		// TODO Auto-generated constructor stub
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

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "UserTestScore [id=" + id + ", userId=" + userId + ", testId=" + testId + ", score=" + score + "]";
	}

}
