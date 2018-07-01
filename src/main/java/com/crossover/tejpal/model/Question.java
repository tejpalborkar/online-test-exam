package com.crossover.tejpal.model;

import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations
 * Hibernate provides JPA implementation
 * @author pankaj
 *
 */
@Entity
@Table(name="questions")
public class Question {

	@Id
	@Column(name="question_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int questionId;
	
	@Column(name="question_text")
	private String questionText;
	
	@Column(name="question_index")
	private int questionIndex;
	
	@Column(name="exam_id")
	private int examId;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="question_id")
	private CorrectAnswers correctAnswer;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id")
	private Set<Answers> answers;

	
	public Set<Answers> getAnswers() {
	if(this.answers instanceof Set){
		this.answers = new TreeSet<Answers>(answers);
	}
		return answers;
	}

	public void setAnswers(Set<Answers> answers) {
		this.answers = answers;
	}

	public Question() {
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public int getQuestionIndex() {
		return questionIndex;
	}

	public void setQuestionIndex(int questionIndex) {
		this.questionIndex = questionIndex;
	}

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public CorrectAnswers getCorrectAnswer() {
		return this.correctAnswer;
	}
	
	
	public void setCorrectAnswer(CorrectAnswers correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + examId;
		result = prime * result + questionId;
		result = prime * result + questionIndex;
		result = prime * result + ((questionText == null) ? 0 : questionText.hashCode());
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
		Question other = (Question) obj;
		if (examId != other.examId)
			return false;
		if (questionId != other.questionId)
			return false;
		if (questionIndex != other.questionIndex)
			return false;
		if (questionText == null) {
			if (other.questionText != null)
				return false;
		} else if (!questionText.equals(other.questionText))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionText=" + questionText + ", questionIndex="
				+ questionIndex + ", examId=" + examId + "]";
	}
	
	
}
