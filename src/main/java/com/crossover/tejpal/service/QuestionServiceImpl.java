package com.crossover.tejpal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossover.tejpal.dao.QuestionDao;
import com.crossover.tejpal.model.Question;

@Service("questionService")
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionDao questionDao;

	@Override
	public Question getQuestionById(int id) {
		return this.questionDao.getQuestionById(id);
	}

	@Override
	public List<Question> getAllQuestionByExamId(int id) {
		return this.questionDao.getAllQuestionByExamId(id);
	}

}
