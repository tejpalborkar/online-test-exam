package com.crossover.tejpal.service;

import java.util.List;

import com.crossover.tejpal.model.Exam;

public interface ExamService {

	public void addExam(Exam e);
	public void updateExam(Exam e);
	public List<Exam> listAllExams();
	public Exam getExamById(int id);
	public void removeExam(int id);
	
}
