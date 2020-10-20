package com.modexforms.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.modexforms.entity.Question;

@Repository
public class QuestionInsertRepository {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Transactional
	public void insertWithQuery(Question question) {
	    entityManager.createNativeQuery("INSERT INTO question (question, answer, group, category, required) VALUES (?,?,?,?,?)")
	      .setParameter(1, question.getId())
	      .setParameter(2, question.getQuestion())
	      .setParameter(3, question.getAnswer())
	      .setParameter(4, question.getCategory())
	      .setParameter(5, question.isRequired())
	      .executeUpdate();
	}
}
