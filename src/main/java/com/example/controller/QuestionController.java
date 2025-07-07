package com.example.controller;

import java.util.List;

import com.example.dto.QuestionDto;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Question;
import com.example.service.QuestionService;

@RestController
@RequestMapping("/api/v1/question")
public class QuestionController {

	private final QuestionService questionService;

	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}

	@PostMapping
	public ResponseEntity<QuestionDto> addQuestion(@RequestBody QuestionDto dto) {
		return ResponseEntity.ok(questionService.addQuestion(dto));
	}


	@GetMapping
	public ResponseEntity<List<QuestionDto>> getAllQuestions() {
		return ResponseEntity.ok(questionService.getAllQuestions());
	}

	@GetMapping("/{id}")
	public ResponseEntity<QuestionDto> getQuestionById(@PathVariable Long id) {
		return ResponseEntity.ok(questionService.getQuestionById(id));
	}

	@GetMapping("/quiz/{quizId}")
	public ResponseEntity<List<QuestionDto>> getQuestionsByQuizId(@PathVariable Long quizId) {
		return ResponseEntity.ok(questionService.getQuestionsByQuizId(quizId));
	}
}

