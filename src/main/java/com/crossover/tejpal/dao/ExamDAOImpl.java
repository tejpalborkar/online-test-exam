package com.crossover.tejpal.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import com.crossover.tejpal.model.Exam;
import com.crossover.tejpal.ote.config.ApplicationContextConfig;
import com.crossover.tejpal.service.ExamService;

@Repository
public class ExamDAOImpl implements ExamDao {

	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	static {
		System.out.println("Inclass ExamDAOImpl");
	}

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addExam(Exam e) {
		logger.info("Entering addExam");
		Session session = this.sessionFactory.getCurrentSession();
		session.save(e);
		logger.info("Exam saved successfully, Exam Details=" + e);

	}

	@Override
	public void updateExam(Exam e) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(e);
		logger.info("Exam updated successfully, Exam Details=" + e);
	}

	@Override
	public List<Exam> listAllExams() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Exam> examList = session.createQuery("from Exam").list();
		for (Exam p : examList) {
			logger.info("Exam List::" + p);
		}
		return examList;
	}

	@Override
	public Exam getExamById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Exam e = (Exam) session.load(Exam.class, new Integer(id));
		logger.info("Exam loaded successfully, Person details=" + e);
		return e;
	}

	@Override
	public void removeExam(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Exam e = (Exam) session.load(Exam.class, new Integer(id));
		if (null != e) {
			session.delete(e);
		}
		logger.info("Exam deleted successfully, Exam details=" + e);
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

		ctx.register(ApplicationContextConfig.class);
		ctx.refresh();

		ExamService myService = (ExamService) ctx.getBean("examService");
		myService.getExamById(1);
		ctx.close();
	}

}
