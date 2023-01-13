package com.exam.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.Teacher;
import com.exam.model.exam.Category;
import com.exam.service.TeacherService;

@RestController
@RequestMapping("/teacher")
@CrossOrigin("*")
public class TeacherController {

	@Autowired
	private TeacherService  teacherService;
	
	@PostMapping("/")
	public Teacher addteacher(@RequestBody Teacher teacher) {
		
			return this.teacherService.addTeacher(teacher);
		
		
	}
	
	
	@PutMapping("/")
	public Teacher updateteacher(@RequestBody Teacher teacher) {
		
			return this.teacherService.addTeacher(teacher);
			
	}
	
	
	
	@DeleteMapping("/{teacherId}")
	public void deleteCategory(@PathVariable("teacherId") Long teacherId) {
		Teacher teacher= new Teacher();
				teacher.setTid(teacherId);
		this.teacherService.deleteTeacher(teacherId);
	}
	
	
	
	
	@GetMapping("/{teacherId}")
	public Teacher getteacher(@PathVariable("teacherId") Long teacherId) {
		
		return this.teacherService.getTeacher(teacherId);
	}
	
	
	@GetMapping("/")
	public Set<Teacher> getallteacher() {
		
		return this.teacherService.getAllTeacher();
	}
	
	
	
	
	
	
	
}
