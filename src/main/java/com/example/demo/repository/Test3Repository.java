package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Test3Model;

@Repository
public interface Test3Repository extends JpaRepository<Test3Model,Integer>{

	@Query(value="Select id,question,option1,option2,option3,option4 from test3",nativeQuery=true)
	List<Test3Model> getAllQuestions();
	
	@Query(value="Select answers from test3",nativeQuery=true)
	List<String> getAllAnswers();
}
