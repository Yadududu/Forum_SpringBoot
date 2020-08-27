package com.lmj.forum.dao;

import com.lmj.forum.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public interface UserMapper {
	/*登陆校验**/
	public User FindUserByUsernameAndPassword(@Param("username")String username,
											@Param("password") String password);
	/*FindUserByUser替代**/
	public User FindUserByUsername(String username);

	/*FindUserByUser替代**/
//	@Select("select * from user where id = #{id}")
	public User FindUserById(String id);

	/*找回密码校验**/
	public User FindUserByUsernameAndPhonenum(@Param("username")String username,
											@Param("phonenum") String phonenum);
	
	public void InsertUser(User user);
	
	public void UpdateUserPassword(User user);
	
	public User FindUserByUser(User user);
}
