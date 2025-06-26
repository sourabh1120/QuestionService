package com.example.service;

import java.util.List;

import com.example.entity.Question;

public interface QuestionService {
	
	public Question addQuestion(Question question); 
	public List<Question> getALLQuestion();
	public Question getOneQuestion(Long id);
	public List<Question> getQuestionByQuizId(Long quizId);
}
