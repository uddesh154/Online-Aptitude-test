package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Test8Model;

@Repository
public interface Test8Repository extends JpaRepository<Test8Model,Integer>{

	@Query(value="select question,option1,option2,option3,option4 from test4",nativeQuery=true)
	List<Test8Model> getAllQuestios();
	
	@Query(value="select answer from test4",nativeQuery=true)
	List<String> getAnswers();
}
