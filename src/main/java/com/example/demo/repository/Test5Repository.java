package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Test5Model;

@Repository
public interface Test5Repository extends JpaRepository<Test5Model,Integer>{

	@Query(value="select question,option1,option2,option3,option4 from test4",nativeQuery=true)
	List<Test5Model> getAllQuestions();
	
	@Query(value="select answer from test4",nativeQuery=true)
	List<String> getAnswers();
}
