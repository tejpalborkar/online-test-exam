package com.crossover.tejpal.service;

import java.util.List;

import com.crossover.tejpal.model.Question;

public interface QuestionService {
	public Question getQuestionById(int id);

	public List<Question> getAllQuestionByExamId(int id);
	
}
