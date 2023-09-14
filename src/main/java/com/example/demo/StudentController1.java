package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController1 {

	@Autowired
	private StudentService1 studentService;
	
	

	@GetMapping("/hello")
	public String hello(Model model)
	{
		model.addAttribute("message","Hello Everyone");
		return "helloworld1";
	}
	
	@GetMapping("/")
	public String displayStudent(Model model)
	{
		model.addAttribute("allstudentlist",studentService.getAllStudents());
		return "index";

	}
	
	@GetMapping("/addnew")
	public String addNewStudent(Model model) 
	{
		Student1 student = new Student1();
		model.addAttribute("student",student);
		return "addnewstudent";
	}
	
	@PostMapping("/save")
	public String saveStudent(@ModelAttribute("student") Student1 student) 
	{
		studentService.addStudent(student);
		return "redirect:/";
	}
	
	@GetMapping("/updateStudent/{id}")
	public String updateForm(@PathVariable("id") long id,Model model)
	{
		model.addAttribute("student", studentService.getStudentById(id));
		return "updateStudent";
	}
	
	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable("id") long id,Model model)
	{
		studentService.deleteStudentById(id);
		return "redirect:/";
	}
	
}

