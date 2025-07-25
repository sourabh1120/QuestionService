package com.example.dto;

public class QuestionDto {
    private Long id;
    private String question;
    private Long quizId;

    public QuestionDto(){

    }
    public QuestionDto(Long id, String question, Long quizId) {
        this.id = id;
        this.question = question;
        this.quizId = quizId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }
}
