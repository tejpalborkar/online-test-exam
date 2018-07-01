package com.crossover.tejpal.dao;

import java.util.List;

import com.crossover.tejpal.model.Exam;

public interface ExamDao {
	public void addExam(Exam e);
	public void updateExam(Exam e);
	public List<Exam> listAllExams();
	public Exam getExamById(int id);
	public void removeExam(int id);
}
