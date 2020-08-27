package com.lmj.forum.dao;

import java.util.List;

import com.lmj.forum.model.Data;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DataMapper {
	
	public List<Data> FindAllData();
	
	public List<Data> FindDataById(String dataId);

	/*FindDataByData替代**/
	public List<Data> FindDataByTitleAndContentAndUId(@Param("title")String title,
												@Param("dcontent")String dcontent,
												@Param("uid")String uid);
	
	public void InsertData(Data data);

	public void UpdateDataAnsnum(@Param("id")String dataId, 
								@Param("ansnum")int ansnum);

	public void DeleteDataById(String dataId);
	
	public List<Data> FindDataByData(Data data);
}
