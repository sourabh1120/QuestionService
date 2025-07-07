package com.example.service;

import java.util.List;

import com.example.dto.QuestionDto;

public interface QuestionService {

	QuestionDto addQuestion(QuestionDto questionDto);

	List<QuestionDto> getAllQuestions();

	QuestionDto getQuestionById(Long id);

	List<QuestionDto> getQuestionsByQuizId(Long quizId);
}
