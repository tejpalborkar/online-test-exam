package com.crossover.tejpal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossover.tejpal.dao.UserTestResultDao;
import com.crossover.tejpal.model.UserTestResult;

@Service("testService")
public class TestServiceImpl implements TestService {

	@Autowired
	private UserTestResultDao testResultDAO;

	@Override
	public void addUserTestResult(UserTestResult e) {
		testResultDAO.addUserTestResult(e);

	}

	@Override
	public void updateUserTestResult(UserTestResult e) {
		testResultDAO.updateUserTestResult(e);
	}

	@Override
	public List<UserTestResult> listAllUserTestResult(String userId) {
		return testResultDAO.listAllUserTestResultByUserId(userId);
	}

	@Override
	public UserTestResult getUserTestResultById(int id) {
		return testResultDAO.getUserTestResultById(id);
	}


	@Override
	public List<UserTestResult> getAllQuestionsByTestId(String testId) {
		return this.testResultDAO.getAllQuestionsByTestId(testId);
	}

	@Override
	public int getScoreByValidatingAnswers(List<UserTestResult> attemtedQuestions) {
		return this.testResultDAO.getScoreByValidatingAnswers(attemtedQuestions);
	}


}
