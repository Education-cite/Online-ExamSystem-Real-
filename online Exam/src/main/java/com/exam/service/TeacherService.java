package com.exam.service;

import java.util.Set;

import com.exam.model.Teacher;

public interface TeacherService {

	public Teacher addTeacher(Teacher teacher);
	public Teacher getTeacher(Long teacherId);
	public Teacher updateTeacher(Teacher teacher);
	public void deleteTeacher(Long teacherId);
	public Set<Teacher> getAllTeacher();




	
	
}
