package com.lmj.forum.model;

import java.io.Serializable;


public class Answer implements Serializable {

    private String id;
    private String atime;
    private String acontent;
    private String d_id;
    private String u_id;

    private User user;
    private Data data;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAtime() {
        return atime;
    }

    public void setAtime(String atime) {
        this.atime = atime;
    }

    public String getAcontent() {
        return acontent;
    }

    public void setAcontent(String acontent) {
        this.acontent = acontent;
    }

    public String getD_id() {
        return d_id;
    }

    public void setD_id(String d_id) {
        this.d_id = d_id;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    @Override
    public String toString() {
        return "Answer [id=" + id + ", atime=" + atime + ", acontent=" + acontent + ", d_id=" + d_id + ", u_id=" + u_id
                + ", user=" + user + ", data=" + data + "]";
    }

}
