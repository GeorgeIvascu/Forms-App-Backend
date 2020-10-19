package com.modexforms.entity;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="question")
public class Question{

	@Id
	@Column(name="id")
	private int id;
	@Column(name="question")
	private String question;
	@Column(name="answer")
	private String answer;
	@Column(name="group")
	private int group;
	@Column(name="category")
	private String category;
	@Column(name="required")
	private boolean required;
	
	public Question() {}

	public Question(int id, String question, String answer, int group, String category, boolean required) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.group = group;
		this.category = category;
		this.required = required;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", answer=" + answer + ", group=" + group
				+ ", category=" + category + ", required=" + required + "]";
	}
	
	
}
