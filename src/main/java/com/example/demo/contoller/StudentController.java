package com.example.demo.contoller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.StudentInfo;
import com.example.demo.model.Test;
import com.example.demo.model.TestDetailsModel;
import com.example.demo.services.StudentServices;
import com.example.demo.services.Test1Services;

@Controller
public class StudentController {

	@Autowired
	private StudentServices studentServices;
	
	@Autowired
	private Test1Services test1Services;
	
	String code;
	
	@GetMapping("/verifyCode")
	public String verify(Model model)
	{
		model.addAttribute("code",code);
		return "index";
	}
	
	@PostMapping("/verifyCode")
	public String verify(String code,HttpServletRequest request)
	{
		TestDetailsModel testInfo= studentServices.getByCode(code);
		request.getSession().setAttribute("code", code);
		request.getSession().setAttribute("testname", testInfo.test_name);
		request.getSession().setAttribute("desciption", testInfo.test_description);
		request.getSession().setAttribute("duration", testInfo.duration);
		return "redirect:/start";
	}
	
	@GetMapping("/start")
	public String start(Model model,HttpSession session)
	{
		model.addAttribute("testName",(String) session.getAttribute("testname"));
		model.addAttribute("description",(String) session.getAttribute("description"));
		model.addAttribute("duration",(String) session.getAttribute("duration"));
		model.addAttribute("info", new StudentInfo());
		return "Student_home";
	}
	
	@PostMapping("/start")
	public String start(@RequestParam("name") String name,@RequestParam("mobile") String mobile,@RequestParam("email") String email,HttpServletRequest request)
	{		
		System.out.println(name);
		request.getSession().setAttribute("name", name);
		request.getSession().setAttribute("mobile", mobile);
		request.getSession().setAttribute("email", email);		
		return "redirect:/test";
	}
	
	@GetMapping("/test")
	public String test(Model model,HttpSession session,HttpServletRequest request)
	{
		String code=(String) session.getAttribute("code");
		TestDetailsModel testInfo=studentServices.getByCode(code);
		request.getSession().setAttribute("filename", code);
		List<Test> test= test1Services.getExcelDataAsList(testInfo.file_name);
		model.addAttribute("test",test);
		List<String> ans=new LinkedList<String>();
		model.addAttribute("ans", ans);
		return "test";
	}
	
	@PostMapping("/test")
	public String test(@RequestParam(value="myArray[]") Integer myArray[],HttpSession session)
	{
		String name=(String) session.getAttribute("name");
		String mobile=(String) session.getAttribute("mobile");
		String email=(String) session.getAttribute("email");
		String filename=(String) session.getAttribute("filename");
		int marks=test1Services.result(myArray);
		test1Services.addResult(filename, name, mobile, email, marks);
		return "success";
	}
}
