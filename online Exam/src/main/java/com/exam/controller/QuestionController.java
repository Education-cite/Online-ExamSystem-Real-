package com.exam.controller;

import java.util.ArrayList;
import java.util.Collections;
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

import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.service.QuestionService;
import com.exam.service.QuizService;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")

public class QuestionController {

	@Autowired
	private QuestionService service;
	
	@Autowired
	private QuizService quizService;
	
	
	
	@PostMapping("/")
	public ResponseEntity<Question> add(@RequestBody Question question){
		
		return ResponseEntity.ok(this.service.addQuestion(question));
		
	}
	
	
	
	@PutMapping("/")
	public ResponseEntity<Question> update(@RequestBody Question question){
		
		return ResponseEntity.ok(this.service.updateQuestion(question));
		
	}
	
	
	
	@GetMapping("/quiz/{qid}")
	
	public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("qid") Long qid){
		
			Quiz quiz = this.quizService.getQuiz(qid);
			Set<Question> questions =	quiz.getQuestions();
			List list=new ArrayList(questions);
			
			if(list.size()>Integer.parseInt(quiz.getNumberofQuestions())) {
				
				list.subList(0, Integer.parseInt(quiz.getNumberofQuestions()+1));
			}
			
			Collections.shuffle(list);
			
			return ResponseEntity.ok(list);
	}
	
	
	

	@GetMapping("/quiz/all/{qid}")
	
	public ResponseEntity<?> getQuestionsOfQuizAdmin(@PathVariable("qid") Long qid){
		
		Quiz quiz = new Quiz();
		quiz.setQid(qid);
		Set<Question> questionsOfQuiz = this.service.getQuestionsofQuiz(quiz);
		
		return ResponseEntity.ok(questionsOfQuiz);
		
		
		
		//	return ResponseEntity.ok(list);
	}
	
	
	
	
	
	
	
	//get single question
	
		@GetMapping("/{quesId}")
		
		public Question get(@PathVariable("quesId") Long quesId) {
			
			return this.service.getQuestion(quesId);
			
		}
		
	
		@DeleteMapping("/{quesId}")
	
		public void delete(@PathVariable("quesId") Long quesId) {
			
			this.service.deleteQuestion(quesId);
		}
	
	
	
	
	
	
	
}
