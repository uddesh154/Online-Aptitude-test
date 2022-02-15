package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Test2Model;

@Repository
public interface Test2Repository extends JpaRepository<Test2Model,Integer>{

	@Query(value="Select id,question,option1,option2,option3,option4 from test2",nativeQuery=true)
	List<Test2Model> getAllQuestions();
	
	@Query(value="Select answers from test2",nativeQuery=true)
	List<String> getAllAnswers();
}
