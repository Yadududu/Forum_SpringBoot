package com.lmj.forum.model;

import java.io.Serializable;

public class User implements Serializable {

    private String id;
    private Boolean admin;
    private String username;
    private String password;
    private String phonenum;

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", admin=" + admin + ", username=" + username + ", password=" + password
                + ", phonenum=" + phonenum + "]";
    }
}
