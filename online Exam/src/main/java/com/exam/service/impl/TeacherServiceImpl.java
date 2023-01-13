package com.exam.service.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.Teacher;
import com.exam.repo.TeacherRepository;
import com.exam.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	private TeacherRepository teacherRepository;

	@Override
	public Teacher addTeacher(Teacher teacher) {
		
		return this.teacherRepository.save(teacher);
	}

	@Override
	public Teacher getTeacher(Long teacherId) {

		return this.teacherRepository.findById(teacherId).get();
	}

	@Override
	public Teacher updateTeacher(Teacher teacher) {

		return this.teacherRepository.save(teacher);
	}

	@Override
	public void deleteTeacher(Long teacherId) {

		Teacher teacher = new Teacher();
		teacher.setTid(teacherId);
		 this.teacherRepository.delete(teacher);
	}

	@Override
	public Set<Teacher> getAllTeacher() {

		return new  LinkedHashSet<>(this.teacherRepository.findAll());
	}

}
