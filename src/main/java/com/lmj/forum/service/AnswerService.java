package com.lmj.forum.service;

import java.util.List;

import com.lmj.forum.dao.AnswerMapper;
import com.lmj.forum.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnswerService{
	
	@Autowired
	private AnswerMapper answerDao;

	public List<Answer> FindAllAnswer(String dataID) {
		return answerDao.FindAllAnswer(dataID);
	}

	public void InsertAnswer(Answer answer) {
		answerDao.InsertAnswer(answer);
	}

	public void DeleteAnswerById(String answerId) {
		Answer answer = new Answer();
		answer.setId(answerId);
		answerDao.DeleteAnswerByAnswer(answer);
	}
}
