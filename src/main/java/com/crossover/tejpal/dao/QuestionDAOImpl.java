package com.crossover.tejpal.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crossover.tejpal.model.Question;
import com.crossover.tejpal.ote.config.ApplicationContextConfig;
import com.crossover.tejpal.service.QuestionService;

@Repository
public class QuestionDAOImpl implements QuestionDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public Question getQuestionById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Question question = (Question) session.load(Question.class, id);
		return question;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Question> getAllQuestionByExamId(int id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Question.class);
		criteria.add(Restrictions.eq("examId", id));
		return criteria.list();
	}
	
	

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

		ctx.register(ApplicationContextConfig.class);
		ctx.refresh();

		QuestionService myService = (QuestionService) ctx.getBean("questionService");
		
		Question q=myService.getQuestionById(1);
		System.out.println(q);
		System.out.println(q.getAnswers());
		System.out.println(q.getCorrectAnswer());
		ctx.close();
	}
}
