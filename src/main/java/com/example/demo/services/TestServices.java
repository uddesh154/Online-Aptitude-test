package com.example.demo.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Test1;
import com.example.demo.model.Test10Model;
import com.example.demo.model.Test2Model;
import com.example.demo.model.Test3Model;
import com.example.demo.model.Test4Model;
import com.example.demo.model.Test5Model;
import com.example.demo.model.Test6Model;
import com.example.demo.model.Test7Model;
import com.example.demo.model.Test8Model;
import com.example.demo.model.Test9Model;
import com.example.demo.repository.Test10Repository;
import com.example.demo.repository.Test1Repository;
import com.example.demo.repository.Test2Repository;
import com.example.demo.repository.Test3Repository;
import com.example.demo.repository.Test4Repository;
import com.example.demo.repository.Test5Repository;
import com.example.demo.repository.Test6Repository;
import com.example.demo.repository.Test7Repository;
import com.example.demo.repository.Test8Repository;
import com.example.demo.repository.Test9Repository; 

import java.util.*;

@Service
@Transactional
public class TestServices {
	
	@Autowired
	private Test1Repository test1Repository;
	
	@Autowired
	private Test2Repository test2Repository;
	
	@Autowired
	private Test3Repository test3Repository;
	
	@Autowired
	private Test4Repository test4Repository;
	
	@Autowired
	private Test5Repository test5Repository;
	
	@Autowired
	private Test6Repository test6Repository;
	
	@Autowired
	private Test7Repository test7Repository;
	
	@Autowired
	private Test8Repository test8Repository;
	
	@Autowired
	private Test9Repository test9Repository;
	
	@Autowired
	private Test10Repository test10Repository;
	
	public Test1 addQuestion(String question,String option1,String option2,String option3,String option4,String answer)
	{
		if(question==null&&option1==null&&option2==null&&option3==null&&option4==null&&answer==null)
		{
			return null;
		}
		else
		{			
			Test1 test1=new Test1();
			test1.setQuestion(question);
			test1.setOption1(option1);
			test1.setOption2(option2);
			test1.setOption3(option3);
			test1.setOption4(option4);
			test1.setAnswer(answer);
			return test1Repository.save(test1);
		}
	}
	
	public List<Test1> showPaper()
	{
		return test1Repository.getAllQuestions();
	}
	
	public Test2Model addQuestion2(String question,String option1,String option2,String option3,String option4,String answer)
	{
		if(question==null&&option1==null&&option2==null&&option3==null&&option4==null&&answer==null)
		{
			return null;
		}
		else
		{			
			Test2Model test1=new Test2Model();
			test1.setQuestion(question);
			test1.setOption1(option1);
			test1.setOption2(option2);
			test1.setOption3(option3);
			test1.setOption4(option4);
			test1.setAnswer(answer);
			return test2Repository.save(test1);
		}
	}
	
	public List<Test2Model> showPaper2()
	{
		return test2Repository.getAllQuestions();
	}
	
	public Test3Model addQuestion3(String question,String option1,String option2,String option3,String option4,String answer)
	{
		if(question==null&&option1==null&&option2==null&&option3==null&&option4==null&&answer==null)
		{
			return null;
		}
		else
		{			
			Test3Model test1=new Test3Model();
			test1.setQuestion(question);
			test1.setOption1(option1);
			test1.setOption2(option2);
			test1.setOption3(option3);
			test1.setOption4(option4);
			test1.setAnswer(answer);
			return test3Repository.save(test1);
		}
	}
	
	public List<Test3Model> showPaper3()
	{
		return test3Repository.getAllQuestions();
	}
	
	public Test4Model addQuestion4(String question,String option1,String option2,String option3,String option4,String answer)
	{
		if(question==null&&option1==null&&option2==null&&option3==null&&option4==null&&answer==null)
		{
			return null;
		}
		else
		{			
			Test4Model test1=new Test4Model();
			test1.setQuestion(question);
			test1.setOption1(option1);
			test1.setOption2(option2);
			test1.setOption3(option3);
			test1.setOption4(option4);
			test1.setAnswer(answer);
			return test4Repository.save(test1);
		}
	}
	
	public List<Test4Model> showPaper4()
	{
		return test4Repository.getAllQuestions();
	}
	
	public Test5Model addQuestion5(String question,String option1,String option2,String option3,String option4,String answer)
	{
		if(question==null&&option1==null&&option2==null&&option3==null&&option4==null&&answer==null)
		{
			return null;
		}
		else
		{			
			Test5Model test1=new Test5Model();
			test1.setQuestion(question);
			test1.setOption1(option1);
			test1.setOption2(option2);
			test1.setOption3(option3);
			test1.setOption4(option4);
			test1.setAnswer(answer);
			return test5Repository.save(test1);
		}
	}
	
	public List<Test5Model> showPaper5()
	{
		return test5Repository.getAllQuestions();
	}
	
	public Test6Model addQuestion6(String question,String option1,String option2,String option3,String option4,String answer)
	{
		if(question==null&&option1==null&&option2==null&&option3==null&&option4==null&&answer==null)
		{
			return null;
		}
		else
		{			
			Test6Model test1=new Test6Model();
			test1.setQuestion(question);
			test1.setOption1(option1);
			test1.setOption2(option2);
			test1.setOption3(option3);
			test1.setOption4(option4);
			test1.setAnswer(answer);
			return test6Repository.save(test1);
		}
	}
	
	public List<Test6Model> showPaper6()
	{
		return test6Repository.getAllQuestions();
	}
	
	public Test7Model addQuestion7(String question,String option1,String option2,String option3,String option4,String answer)
	{
		if(question==null&&option1==null&&option2==null&&option3==null&&option4==null&&answer==null)
		{
			return null;
		}
		else
		{			
			Test7Model test1=new Test7Model();
			test1.setQuestion(question);
			test1.setOption1(option1);
			test1.setOption2(option2);
			test1.setOption3(option3);
			test1.setOption4(option4);
			test1.setAnswer(answer);
			return test7Repository.save(test1);
		}
	}
	
	public List<Test7Model> showPaper7()
	{
		return test7Repository.getAllQuestions();
	}
	
	public Test8Model addQuestion8(String question,String option1,String option2,String option3,String option4,String answer)
	{
		if(question==null&&option1==null&&option2==null&&option3==null&&option4==null&&answer==null)
		{
			return null;
		}
		else
		{			
			Test8Model test1=new Test8Model();
			test1.setQuestion(question);
			test1.setOption1(option1);
			test1.setOption2(option2);
			test1.setOption3(option3);
			test1.setOption4(option4);
			test1.setAnswer(answer);
			return test8Repository.save(test1);
		}
	}
	
	public List<Test8Model> showPaper8()
	{
		return test8Repository.getAllQuestios();
	}
	
	public Test9Model addQuestion9(String question,String option1,String option2,String option3,String option4,String answer)
	{
		if(question==null&&option1==null&&option2==null&&option3==null&&option4==null&&answer==null)
		{
			return null;
		}
		else
		{			
			Test9Model test1=new Test9Model();
			test1.setQuestion(question);
			test1.setOption1(option1);
			test1.setOption2(option2);
			test1.setOption3(option3);
			test1.setOption4(option4);
			test1.setAnswer(answer);
			return test9Repository.save(test1);
		}
	}
	
	public List<Test9Model> showPaper9()
	{
		return test9Repository.getAllQuestios();
	}
	
	public Test10Model addQuestion10(String question,String option1,String option2,String option3,String option4,String answer)
	{
		if(question==null&&option1==null&&option2==null&&option3==null&&option4==null&&answer==null)
		{
			return null;
		}
		else
		{			
			Test10Model test1=new Test10Model();
			test1.setQuestion(question);
			test1.setOption1(option1);
			test1.setOption2(option2);
			test1.setOption3(option3);
			test1.setOption4(option4);
			test1.setAnswer(answer);
			return test10Repository.save(test1);
		}
	}
	
	public List<Test10Model> showPaper10()
	{
		return test10Repository.getAllQuestios();
	}

}
