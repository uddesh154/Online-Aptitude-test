package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TestDetailsModel;

@EnableJpaRepositories
@Repository
public interface TestDetailsRepository extends JpaRepository<TestDetailsModel,Integer>{

	public TestDetailsModel findById(int id);
	
	@Query(value="select * from test_details where test_code=?",nativeQuery=true)
	public TestDetailsModel findByTest_code(String code);
	
	@Query(value="select * from test_details where owner_name=?",nativeQuery=true)
	public List<TestDetailsModel> findByOwner_name(String owner);
}
