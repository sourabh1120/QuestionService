package com.example.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Question;
import com.example.repository.QuestionRepo;
import com.example.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	private QuestionRepo questionRepository;

	public QuestionServiceImpl(QuestionRepo questionRepository) {
		this.questionRepository = questionRepository;
	}

	@Override
	public Question addQuestion(Question question) {
		return questionRepository.save(question);
	}

	@Override
	public List<Question> getALLQuestion() {
		return questionRepository.findAll();
	}

	@Override
	public Question getOneQuestion(Long id) {
		return questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question Not Found"));
	}

	@Override
	public List<Question> getQuestionByQuizId(Long quizId) {
		return questionRepository.findByQuizId(quizId);
	}

}
