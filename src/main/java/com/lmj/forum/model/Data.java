package com.lmj.forum.model;

import java.io.Serializable;

public class Data implements Serializable{

	private String id;
	private String dtime;
	private String title;
	private String dcontent;
	private Integer ansnum;
	private String u_id;

	private User user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDtime() {
		return dtime;
	}

	public void setDtime(String dtime) {
		this.dtime = dtime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDcontent() {
		return dcontent;
	}

	public void setDcontent(String dcontent) {
		this.dcontent = dcontent;
	}

	public Integer getAnsnum() {
		return ansnum;
	}

	public void setAnsnum(Integer ansnum) {
		this.ansnum = ansnum;
	}

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Data [id=" + id + ", dtime=" + dtime + ", title=" + title + ", dcontent=" + dcontent + ", ansnum="
				+ ansnum + ", u_id=" + u_id  + ", user=" + user + "]";
	}

	
	
}
