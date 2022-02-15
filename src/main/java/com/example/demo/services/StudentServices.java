package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.TestDetailsModel;
import com.example.demo.repository.TestDetailsRepository;

@Service
@Transactional
public class StudentServices {

	@Autowired
	private TestDetailsRepository testDetailsRepository;
	
	public TestDetailsModel getByCode(String code)
	{
		return testDetailsRepository.findByTest_code(code);
	}
	
	public void writeResult(String file,List<String> info)
	{
		
	}
}
