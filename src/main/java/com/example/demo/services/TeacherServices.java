package com.example.demo.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TeacherModel;
import com.example.demo.repository.TeacherRepository;

@Service
@Transactional
public class TeacherServices {

	@Autowired
	private TeacherRepository teacherRepository;
	
	TeacherServices(TeacherRepository teacherRepository)
	{
		this.teacherRepository=teacherRepository;
	}
	
	public TeacherModel registerTeacher(String name,String email,String mobile,String password)
	{
		if(name!=null&&email!=null&&mobile!=null&&password!=null)
		{
			TeacherModel teacherModel=new TeacherModel();
			teacherModel.setName(name);
			teacherModel.setEmail(email);
			teacherModel.setMobile(mobile);
			teacherModel.setPassword(password);
			return teacherRepository.save(teacherModel);
		}
		else
		{
			return null;
		}
	}
	
	public TeacherModel authenticate(String email,String password)
	{
		return teacherRepository.findByEmailAndPassword(email, password);
	}
}
