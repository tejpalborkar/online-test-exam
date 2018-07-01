package com.crossover.tejpal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "correct_answers")
public class CorrectAnswers {
	@Id
	@Column(name = "question_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int questionId;

	@Column(name = "correct_ans_id")
	private int correctAnsId;

	public CorrectAnswers() {
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getCorrectAnsId() {
		return correctAnsId;
	}

	public void setCorrectAnsId(int correctAnsId) {
		this.correctAnsId = correctAnsId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + correctAnsId;
		result = prime * result + questionId;
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
		CorrectAnswers other = (CorrectAnswers) obj;
		if (correctAnsId != other.correctAnsId)
			return false;
		if (questionId != other.questionId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CorrectAnswers [questionId=" + questionId + ", correctAnsId=" + correctAnsId + "]";
	}

}
