package com.crossover.tejpal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crossover.tejpal.dao.ExamDao;
import com.crossover.tejpal.model.Exam;

@Service("examService")
public class ExamServiceImpl implements ExamService {
	static {
		System.out.println("Inclass ExamServiceImpl");
	}

	@Autowired
	private ExamDao examDAO;

	public void setExamDAO(ExamDao personDAO) {
		this.examDAO = personDAO;
	}

	@Override
	@Transactional
	public void addExam(Exam e) {
		this.examDAO.addExam(e);

	}

	@Override
	@Transactional
	public void updateExam(Exam e) {
		this.examDAO.updateExam(e);

	}

	@Override
	public List<Exam> listAllExams() {
		return this.examDAO.listAllExams();
	}

	@Override
	@Transactional
	public Exam getExamById(int id) {
		return this.examDAO.getExamById(id);
	}

	@Override
	@Transactional
	public void removeExam(int id) {
		this.examDAO.removeExam(id);

	}

}
