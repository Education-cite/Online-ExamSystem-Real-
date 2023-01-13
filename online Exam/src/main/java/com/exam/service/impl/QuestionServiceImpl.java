package com.exam.service.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.model.exam.Question;
import com.exam.model.exam.Quiz;
import com.exam.repo.QuestionRepository;
import com.exam.service.QuestionService;


@Service
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Question addQuestion(Question question) {
		return this.questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {

		return this.questionRepository.save(question);
	}

	@Override
	public Set<Question> getQuestions() {


		return new LinkedHashSet<>( this.questionRepository.findAll());
	}

	@Override
	public Question getQuestion(Long questionId) {
		
		return this.questionRepository.findById(questionId).get();
	}

	@Override
	public Set<Question> getQuestionsofQuiz(Quiz quiz) {

		return this.questionRepository.findByQuiz(quiz);
	}

	@Override
	public void deleteQuestion(Long quesId) {

		Question question = new Question();
		question.setQuesId(quesId);
		this.questionRepository.delete(question);
	}

}
