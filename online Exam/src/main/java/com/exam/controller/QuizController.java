package com.exam.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.exam.Category;
import com.exam.model.exam.Quiz;
import com.exam.service.QuizService;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {

	@Autowired
	private QuizService quizService;
	
	@PostMapping("/")
	public Quiz addQuiz(@RequestBody Quiz quiz) {
		
		return this.quizService.addQuiz(quiz);
	}
	
	
	@GetMapping("/{qid}")
	public Quiz quiz(@PathVariable("qid") Long qid) {
		return this.quizService.getQuiz(qid);
	}
	
	
	@GetMapping("/")
	public Set<Quiz>  quizzes() {
		return this.quizService.getQuizzes();
	}
	
	
	@PutMapping("/")
	public Quiz update(@RequestBody Quiz quiz) {
		
		return this.quizService.updateQuiz(quiz);
	}
	
	
	@DeleteMapping("/{qid}")
	
	public void delete(@PathVariable("qid") Long qid) {
		this.quizService.deleteQuiz(qid);
	}
	
	
	@GetMapping("/category/{cid}")
	public List<Quiz> getQuizzesOfCategory(@PathVariable("cid") Long cid){
		
		Category category=new Category();
		category.setCid(cid);
		return this.quizService.getQuizzesOfCategory(category);
		
	}
	
	
	@GetMapping("/active")
	public List<Quiz> getActiveQuiz(){
		return this.quizService.getActiveQuizzes();
	}
	
	
	@GetMapping("/category/active/{cid}")
	public List<Quiz> getActiveQuizOfCategory(@PathVariable("cid") Long cid){
	Category category =	new Category();
	category.setCid(cid);
		return this.quizService.getActiveQuizzesOfCategory(category);
	}
	
	
	
}
