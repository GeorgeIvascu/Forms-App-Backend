package com.modexforms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.modexforms.entity.Question;
import com.modexforms.service.QuestionService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class QuestionController {

	@Autowired
	private QuestionService service;
	
	@GetMapping("/test")
	public String test() {
		return "merge";
	}
	
	@GetMapping("/q")
	public List<Question> getQuestions(){
		return this.service.getQuestions();
	}
	
	@GetMapping("/q/{group}")
	public List<Question> getQuestionsByGroup(@PathVariable int group){
		return this.service.getQuestionsByGroup(group);
	}
	
	@GetMapping("/q/del/{id}")
	public String deleteById(@PathVariable int id) {
		this.service.deleteQuestion(id);
		return "Question" + id + "deleted";
	}
}
