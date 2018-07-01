package com.crossover.tejpal.service;

import java.util.List;

import com.crossover.tejpal.model.UserTestResult;

public interface TestService {

	public void addUserTestResult(UserTestResult e);
	public void updateUserTestResult(UserTestResult e);
	public List<UserTestResult> listAllUserTestResult(String userId);
	public UserTestResult getUserTestResultById(int id);
	
	public List<UserTestResult> getAllQuestionsByTestId(String testId);
	public int getScoreByValidatingAnswers(List<UserTestResult> attemtedQuestions);
}
