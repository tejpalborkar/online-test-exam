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
@Table(name = "answers")
public class Answers implements Comparable<Answers>{

	@Id
	@Column(name = "answer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int answerID;

	@Column(name = "ans_text")
	private String ansText;

	@Column(name = "ans_index")
	private int ansIndex;
	
	@Column(name = "question_id")
	private int questionId;


	public Answers() {

	}

	public int getAnswerID() {
		return answerID;
	}

	public void setAnswerID(int answerID) {
		this.answerID = answerID;
	}

	public String getAnsText() {
		return ansText;
	}

	public void setAnsText(String ansText) {
		this.ansText = ansText;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getAnsIndex() {
		return ansIndex;
	}

	public void setAnsIndex(int ansIndex) {
		this.ansIndex = ansIndex;
	}

	@Override
	public String toString() {
		return "Answers [answerID=" + answerID + ", ansText=" + ansText + ", questionId=" + questionId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ansIndex;
		result = prime * result + ((ansText == null) ? 0 : ansText.hashCode());
		result = prime * result + answerID;
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
		Answers other = (Answers) obj;
		if (ansIndex != other.ansIndex)
			return false;
		if (ansText == null) {
			if (other.ansText != null)
				return false;
		} else if (!ansText.equals(other.ansText))
			return false;
		if (answerID != other.answerID)
			return false;
		if (questionId != other.questionId)
			return false;
		return true;
	}

	@Override
	public int compareTo(Answers o) {
		return this.ansIndex-o.ansIndex;
	}


}
