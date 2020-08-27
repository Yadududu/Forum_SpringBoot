package com.lmj.forum.dao;

import com.lmj.forum.model.Answer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerMapper {
	
	public List<Answer> FindAllAnswer(String dataId);
	
	public void InsertAnswer(Answer answer);

	/*DeleteAnswerByAnswer替代**/
	public void DeleteAnswerById(String answerId);

	/*DeleteAnswerByAnswer替代**/
	public void DeleteAnswerByDid(String dataId);
	
	public void DeleteAnswerByAnswer(Answer answer);
}
