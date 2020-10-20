package com.modexforms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
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
	
	@CrossOrigin(origins = "http://localhost:8080/?#/admin")
	@GetMapping("/q/del/{id}")
	public String deleteById(@PathVariable int id) {
		this.service.deleteQuestion(id);
		return "Question" + id + "deleted";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/q/add", 
			  produces = "application/json", 
			  consumes = "application/json",
			  method=RequestMethod.POST)
	public void addQuestion(@RequestBody Question q) {
		service.insertQuestion(q);
	}
}
