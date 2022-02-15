package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Test1;

@Repository
public interface Test1Repository extends JpaRepository<Test1 , Long>
{
	@Query(value="Select id,question,option1,option2,option3,option4 from test1",nativeQuery=true)
	List<Test1> getAllQuestions();
	
	@Query(value="Select answers from test1",nativeQuery=true)
	List<String> getAllAnswers();
}
