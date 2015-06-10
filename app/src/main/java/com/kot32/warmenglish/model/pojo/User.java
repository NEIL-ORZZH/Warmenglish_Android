package com.kot32.warmenglish.model.pojo;

import java.util.HashSet;
import java.util.Set;

public class User {
	private int id;
	private String name;
	private String username;
	private String password;
	//一个老师管理很多班级
	private Set<Class> classes = new HashSet<Class>();
	//一个老师发出很多消息
	private Set<Message> messages = new HashSet<Message>();
	
	
	public int getId() {
		return id;
		
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Class> getClasses() {
		return classes;
	}

	public void setClasses(Set<Class> classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", username=" + username
				+ ", password=" + password + ", classes=" + classes + "]";
	}

}
