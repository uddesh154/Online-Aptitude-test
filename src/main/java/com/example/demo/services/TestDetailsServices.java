package com.example.demo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TestDetailsModel;
import com.example.demo.repository.TestDetailsRepository;

@Service
@Transactional
public class TestDetailsServices {

	@Autowired
	private TestDetailsRepository testDetailsRepository;	
		
	public TestDetailsServices() {}
			
	public TestDetailsModel getId(int id)
	{
		return testDetailsRepository.findById(id);
	}
	
	public List<TestDetailsModel> findByOwner(String owner)
	{
		List<TestDetailsModel> list=testDetailsRepository.findByOwner_name(owner);
		return list;
	}
	
	public void addTestDetails(String test_name ,String code,String owner,String duration,String fromdate,String todate,String starttime,String endtime,String totalquestion,String filename,String description)
	{
		TestDetailsModel testDetailsModel=new TestDetailsModel();
		testDetailsModel.setTest_name(test_name);
		testDetailsModel.setTest_code(code);
		testDetailsModel.setOwner_name(owner);
		testDetailsModel.setDuration(duration);
		testDetailsModel.setFrom_date(fromdate);
		testDetailsModel.setTo_date(todate);
		testDetailsModel.setStart_time(starttime);
		testDetailsModel.setEnd_time(endtime);
		testDetailsModel.setFile_name(filename);
		testDetailsModel.setTotal_questions(totalquestion);
		testDetailsModel.setTest_description(description);
		testDetailsRepository.save(testDetailsModel);
	}
}
