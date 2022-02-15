package com.example.demo.contoller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.TeacherModel;
import com.example.demo.model.TestDetailsModel;
import com.example.demo.services.TeacherServices;
import com.example.demo.services.Test1Services;
import com.example.demo.services.TestDetailsServices;

@Controller
public class TeacherController {

	@Autowired
	private TeacherServices teacherServices;
	
	@Autowired
	private TestDetailsServices testDetailsServices;
	
	@Autowired
	private Test1Services test1Services;
	
	@GetMapping("/login")
	public String teacher_login(Model model)
	{
		model.addAttribute("login", new TeacherModel());
		return "teacher_login";
	}
	
	@GetMapping("/register")
	public String teacher_registration(Model model)
	{
		model.addAttribute("register",new TeacherModel());
		return "teacher_registration";
	}
	
	@PostMapping("/login")
	public String teacher_login(TeacherModel teacherModel,HttpServletRequest request)
	{		
		System.out.println(teacherModel);
		TeacherModel authenticate=teacherServices.authenticate(teacherModel.getEmail(), teacherModel.getPassword());
		System.out.println(authenticate);
		if(authenticate!=null)
		{
			System.out.println("login");
			request.getSession().setAttribute("name", teacherModel.getEmail());
			return "redirect:/home";
		}
		else
		{
			return "teacher_login";
		}
	}
	
	@PostMapping("/register")
	public String teacher_registration(TeacherModel teacherModel)
	{
		System.out.println(teacherModel);
		TeacherModel register=teacherServices.registerTeacher(teacherModel.getName(), teacherModel.getEmail(), teacherModel.getMobile(), teacherModel.getPassword());
		return register==null ? "teacher_registration" : "redirect:/login";
	}
	
	@GetMapping("/home")
	public String teacher_home(Model model,HttpSession session)
	{
		String owner=(String) session.getAttribute("name");
		model.addAttribute("se",owner);
		List<TestDetailsModel> testDetailsModel=testDetailsServices.findByOwner(owner);
		model.addAttribute("owner", testDetailsModel);
		return "teacher_home";
	}
	
	@GetMapping("/testDetails")
	public String addDetails(Model model)
	{
		model.addAttribute("testDetails",new TestDetailsModel());		
		return "test_details";
	}
	
	String filename;
	
	@PostMapping("/testDetails")
	public String addDetails(Model model,TestDetailsModel testDetailsModel,HttpSession session,HttpServletRequest request)
	{
		String owner=(String) session.getAttribute("name");
		System.out.println(filename);
		System.out.println(testDetailsModel);
		testDetailsServices.addTestDetails(testDetailsModel.getTest_name(),testDetailsModel.getTest_code(),owner,testDetailsModel.getDuration(),testDetailsModel.getFrom_date(),testDetailsModel.getTo_date(),testDetailsModel.getStart_time(),testDetailsModel.getEnd_time(),testDetailsModel.getTotal_questions(),filename,testDetailsModel.getTest_description());
		test1Services.createResultFile(testDetailsModel.getTest_code());
		return "CreatePaper";
	}
	
	   @PostMapping("/uploadFile")
	    public String uploadFile(@RequestParam("file") MultipartFile file, Model model) {

	        test1Services.uploadFile(file);

	        model.addAttribute("message",
	            "You have successfully uploaded '"+ file.getOriginalFilename()+"' !");
	        filename=file.getOriginalFilename();	        
	        try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return "redirect:/testDetails";
	    } 

	   
}
