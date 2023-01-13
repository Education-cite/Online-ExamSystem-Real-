package com.exam.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

	
}
