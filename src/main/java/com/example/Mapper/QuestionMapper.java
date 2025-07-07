package com.example.Mapper;


import com.example.dto.QuestionDto;
import com.example.entity.Question;

public class QuestionMapper {


    public static QuestionDto toDto(Question question) {
        if (question == null) {
            return null;
        }

        QuestionDto dto = new QuestionDto();
        dto.setId(question.getId());
        dto.setQuestion(question.getQuestion());
        dto.setQuizId(question.getQuizId());
        return dto;
    }
    public static Question toEntity(QuestionDto dto) {
        if (dto == null) {
            return null;
        }

        Question question = new Question();
        question.setId(dto.getId());
        question.setQuestion(dto.getQuestion());
        question.setQuizId(dto.getQuizId());
        return question;
    }
}