package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Test4Model;

import java.util.List;

@Repository
public interface Test4Repository extends JpaRepository<Test4Model,Integer>{

	@Query(value="select question,option1,option2,option3,option4 from test4",nativeQuery=true)
	List<Test4Model> getAllQuestions();
	
	@Query(value="select answer from test4",nativeQuery=true)
	List<String> getAnswers();
}
