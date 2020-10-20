package com.modexforms.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.modexforms.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer>{
	

	@Query(value = "SELECT q FROM Question q where q.group=?1")
	List<Question> findByGroup(int group);

}
