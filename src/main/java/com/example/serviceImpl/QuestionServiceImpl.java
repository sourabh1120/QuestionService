package com.example.serviceImpl;

import com.example.Mapper.QuestionMapper;
import com.example.dto.QuestionDto;
import com.example.entity.Question;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.QuestionRepository;
import com.example.service.QuestionService;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

	private final QuestionRepository questionRepository;

	public QuestionServiceImpl(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}

	@Override
	@CachePut(value = "Questions", key = "#result.id")
	public QuestionDto addQuestion(QuestionDto questionDto) {
		Question saved = questionRepository.save(QuestionMapper.toEntity(questionDto));
		return QuestionMapper.toDto(saved);
	}

	@Override
	public List<QuestionDto> getAllQuestions() {
		return questionRepository.findAll()
				.stream()
				.map(QuestionMapper::toDto)
				.collect(Collectors.toList());
	}

	@Override
	@Cacheable(value = "Questions", key = "#id")
	public QuestionDto getQuestionById(Long id) {
		Question question = questionRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Question not found with ID: " + id));
		return QuestionMapper.toDto(question);
	}

	@Override
	@Cacheable(value = "QuestionsByQuiz", key = "#quizId")
	public List<QuestionDto> getQuestionsByQuizId(Long quizId) {
		return questionRepository.findByQuizId(quizId)
				.stream()
				.map(QuestionMapper::toDto)
				.collect(Collectors.toList());
	}
}
