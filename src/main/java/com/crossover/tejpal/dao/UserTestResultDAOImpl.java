package com.crossover.tejpal.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crossover.tejpal.model.Answers;
import com.crossover.tejpal.model.CorrectAnswers;
import com.crossover.tejpal.model.UserTestResult;

@Repository
public class UserTestResultDAOImpl implements UserTestResultDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void addUserTestResult(UserTestResult e) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(e);
	}

	@Override
	@Transactional
	public void updateUserTestResult(UserTestResult e) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(e);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<UserTestResult> listAllUserTestResultByUserId(String userId) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserTestResult.class);
		criteria.add(Restrictions.eq("userId", userId));
		return criteria.list();
	}

	@Override
	@Transactional
	public UserTestResult getUserTestResultById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<UserTestResult> getAllQuestionsByTestId(String id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserTestResult.class);
		criteria.add(Restrictions.eq("testId", id));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public int getScoreByValidatingAnswers(List<UserTestResult> attemtedQuestions) {

		int score = 0;
		Session session = sessionFactory.getCurrentSession();
		for (UserTestResult userTestResult : attemtedQuestions) {
			Criteria criteria = session.createCriteria(CorrectAnswers.class);
			criteria.add(Restrictions.eq("questionId",userTestResult.getQuestionId()));
			List<CorrectAnswers> answers=criteria.list();
			CorrectAnswers ans=answers.get(0);
			
			Criteria criteriaForAns = session.createCriteria(Answers.class);
			List<Answers> actualAnswers=criteriaForAns.add(Restrictions.eq("answerID",ans.getCorrectAnsId())).list();
			Answers answer = actualAnswers.get(0);
			
			if(answer.getAnsIndex() == userTestResult.getReceivedAnsIndex()){
				score+=1;
			}
			
		}
		return score;
	}
}
