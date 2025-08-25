package com.sonuit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sonuit.binding.Student;
import com.sonuit.entity.StudentEntity;
import com.sonuit.repo.StudentRepository;
@Controller
public class StudentController {
	@Autowired
	private StudentRepository repo; //inject The StudentRepositoyy to our RestController
	
	@GetMapping("/") //the below method binded to GetRequest & this method used to load the form only 
	public String loadForm(Model model) { //the Model obj is used to send the data(courseList, timingList) from Controller to UI
		List<String> courseList = new ArrayList<>(); //Create one ArrayList obj & for this obj i want to set the courses which i 
		courseList.add("SpringBoot");												           //want to display in the dropDown
		courseList.add("devops");
		courseList.add("AWS");
		
		List<String> timingList = new ArrayList<>(); //Create one ArrayList obj & for this obj i want to set the timings which i
		timingList.add("Morning");															   //want to display in the checkBox
		timingList.add("Afternoon");
		timingList.add("Evening");
		
		Student student = new Student();  //Form Binding Object
		
		//To send the data to UI we use Model.addAttribute("Key", value);
		model.addAttribute("courses",courseList);
		model.addAttribute("timings",timingList);
		model.addAttribute("student",student); //sending the form binding object to UI by using model
		
		return "index";
	}
	
	@PostMapping("/save") //this below method i want to bind a PostRequest
	public String handleSubmit(Student s, Model model) { //This method is used to handle the PostRequest
		System.out.println(s); //print the student obj in console
		model.addAttribute("msg", "Student Data Saved Sucessfully"); //print a Sucess message
		List<String> courseList = new ArrayList<>(); //Create one ArrayList obj & for this obj i want to set the courses which i 
		courseList.add("SpringBoot");												           //want to display in the dropDown
		courseList.add("devops");
		courseList.add("AWS");
		
		List<String> timingList = new ArrayList<>(); //Create one ArrayList obj & for this obj i want to set the timings which i
		timingList.add("Morning");															   //want to display in the checkBox
		timingList.add("Afternoon");
		timingList.add("Evening");
		
		Student student = new Student();  //Form Binding Object
		
		//To send the data to UI we use Model.addAttribute("Key", value);
		model.addAttribute("courses",courseList);
		model.addAttribute("timings",timingList);
		model.addAttribute("student",student); //sending the form binding object to UI by using model
		
		StudentEntity entity = new StudentEntity(); //Logic to save
		BeanUtils.copyProperties(s, entity); //copy data from binding obj to entity object
		entity.setTiming(Arrays.toString(s.getTiming())); //manually set the time and convert from array to string format
		repo.save(entity); //save the data 
		return "index";
	}
}
