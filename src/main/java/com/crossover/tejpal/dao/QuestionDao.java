package com.crossover.tejpal.dao;

import java.util.List;

import com.crossover.tejpal.model.Question;

public interface QuestionDao {

	public Question getQuestionById(int id);

	public List<Question> getAllQuestionByExamId(int id);

}
