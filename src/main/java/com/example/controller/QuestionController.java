package com.example.controller;

import java.util.List;

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

	private QuestionService questionService;

	public QuestionController(QuestionService questionService) {
		this.questionService = questionService;
	}
	
	@PostMapping("/addQuestion")
	public Question addQuestion(@RequestBody Question question) {
		return questionService.addQuestion(question);
	}
	
	@GetMapping("/allQuestion")
	public List<Question> getAllQuestion(){
		return questionService.getALLQuestion();
	}

	@GetMapping("/{id}")
	public Question getQuestionById(@PathVariable("id") Long questionId) {
		return questionService.getOneQuestion(questionId);
	}
	
	@GetMapping("/quiz/{id}")
	public List<Question> getQuestionByQuizId(@PathVariable("id") Long quizId) {
		return questionService.getQuestionByQuizId(quizId);
		
	}
}

