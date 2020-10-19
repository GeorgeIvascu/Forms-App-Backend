package com.modexforms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modexforms.entity.Question;
import com.modexforms.repository.QuestionRepository;

@Service
public class QuestionService {
	
	private QuestionRepository questionRepository;
	
	@Autowired
	public QuestionService(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}
	
	public List<Question> getQuestions(){
		return this.questionRepository.findAll();
	}
	
	public List<Question> getQuestionsByGroup(int group){
		return this.questionRepository.findByGroup(group);
	}
	
	public void deleteQuestion(int id) {
		this.questionRepository.deleteById(id);
	}
	
	public void addQuestion(Question q) {
		this.questionRepository.save(q);
	}

}
