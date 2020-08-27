package com.lmj.forum.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class SessionManager {
	//用户保存登陆用户,单点登陆
	public static Map<String,HttpSession> SessionMap = new HashMap<String,HttpSession>();
}
