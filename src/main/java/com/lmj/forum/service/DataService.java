package com.lmj.forum.service;

import java.util.List;

import com.lmj.forum.dao.AnswerMapper;
import com.lmj.forum.dao.DataMapper;
import com.lmj.forum.model.Answer;
import com.lmj.forum.model.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DataService {
	
	@Autowired
	private DataMapper dataDao;
	
	@Autowired
	private AnswerMapper answerDao;

	public List<Data> FindAllData() {
		return dataDao.FindAllData();
	} 

	public Data FindDataById(String dataId) {
		List<Data> list = dataDao.FindDataById(dataId);
		return list.size()==0?null:list.get(0);
	}

	public String FindDataIdByData(Data data) {
		List<Data> dataList = dataDao.FindDataByData(data);
		return dataList!=null?dataList.get(dataList.size()-1).getId():"";
	}

	public Data InsertData(Data data) {
		dataDao.InsertData(data);
		return data;
	}

	public void UpdateDataAnsnum(String dataID, int ansnum) {
		Data d = new Data();
		d.setId(dataID);
		List<Data> list = dataDao.FindDataByData(d);
		dataDao.UpdateDataAnsnum(dataID, list.get(0).getAnsnum() + ansnum);
	}

	public void DeleteDataById(String dataID) {
		Answer answer = new Answer();
		answer.setD_id(dataID);
		answerDao.DeleteAnswerByAnswer(answer);
		dataDao.DeleteDataById(dataID);
	}
}
