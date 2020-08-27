package com.lmj.forum.service;

import com.lmj.forum.dao.UserMapper;
import com.lmj.forum.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

	@Autowired
	private UserMapper userDao;

	public User FindUserByUsernameAndPassword(User user) {
		User u = userDao.FindUserByUsernameAndPassword(user.getUsername(), user.getPassword());
		return u!=null?u:null;
	}

	public boolean FindUserByUsername(String username) {
		User u = new User();
		u.setUsername(username);
		User user = userDao.FindUserByUser(u);
		return user!=null?true:false;
	}

	public String FindUsernameById(String id) {
//		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//		UserMapper userMapper = (UserMapper) ac.getBean("userMapper");
		User u = new User();
		u.setId(id);
		User user = userDao.FindUserByUser(u);
		return user.getUsername();
	}

	public boolean InsertUser(User user) {
		User u = userDao.FindUserByUsername(user.getUsername());
		if(u==null) {
			userDao.InsertUser(user);
			return true;
		}else {
			return false;
		}
	}

	public boolean UpdateUserPassword(User user) {
		User u = userDao.FindUserByUsernameAndPhonenum(user.getUsername(), user.getPhonenum());
		if(u!=null) {
			userDao.UpdateUserPassword(user);
			return true;
		}else {
			return false;
		}
	}
}
