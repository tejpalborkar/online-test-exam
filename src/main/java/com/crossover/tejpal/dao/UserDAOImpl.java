package com.crossover.tejpal.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import com.crossover.tejpal.model.Exam;
import com.crossover.tejpal.model.Test;
import com.crossover.tejpal.model.User;
import com.crossover.tejpal.ote.config.ApplicationContextConfig;
import com.crossover.tejpal.service.ExamService;
import com.crossover.tejpal.service.UserService;

@Repository
public class UserDAOImpl implements UserDao {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		
		session.persist(user);
		logger.info("User saved successfully, User Details=" + user);
	}

	@Override
	public void updateUser(User p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("User updated successfully, User Details=" + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> userList = session.createQuery("from User").list();
		for (User p : userList) {
			logger.info("Person List::" + p);
		}
		return userList;
	}

	@Override
	public User getUserById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User u = (User) session.load(User.class, new Integer(id));
		logger.info("User loaded successfully, Person details=" + u);
		return u;
	}

	@Override
	public void removeUser(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User p = (User) session.load(User.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		logger.info("User deleted successfully, User details=" + p);
	}

	@Override
	public User getUserByName(String userName) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class);
		Criterion scriteria = Restrictions.eq("userName", userName);
		criteria.add(scriteria);
		@SuppressWarnings("unchecked")
		List<User> users = criteria.list();
		return users.size()>0?users.get(0):null;
	}

	@Override
	public void createTest(Test test) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(test);
		logger.info("Test create successfully, Test Details=" + test);
	}
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

		ctx.register(ApplicationContextConfig.class);
		ctx.refresh();

		UserService myService = (UserService) ctx.getBean("userService");
		ExamService examService = (ExamService) ctx.getBean("examService");
		User u = new User();
		u.setPassword("password");
		u.setUserId(0);
		u.setUserName("tejpal");
		ctx.close();
		
		Exam exam =examService.getExamById(1);
		Test test=new Test("123",exam.getExamName(), exam.getExamId(),5);
		myService.createTestForUser(test);
		myService.addUser(u);

	}

	
}
