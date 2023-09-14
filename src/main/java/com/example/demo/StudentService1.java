package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService1 {
    
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student1> getAllStudents()
	{
		return studentRepository.findAll();
	}
	
	public void addStudent(Student1 student)
	{
		studentRepository.save(student);
	}
	
	public Student1 getStudentById(long id) 
	{
		Optional<Student1> optional = studentRepository.findById(id);
		Student1 student = null;
		if(optional.isPresent()) 
			student = optional.get();
		else
			throw new RuntimeException("Student not found for id : "+id);
		return student;	
		
		
	}

	public void deleteStudentById(long id) {
		studentRepository.deleteById(id);
		
	}
	
}
