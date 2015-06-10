package com.kot32.warmenglish.model.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Student implements Serializable{
	private int id;
	private String name;
	private String username;
	private String password;

	private Class clazz;
	private User user;
	private Group group;
	// 学生有很多次成绩
	private Set<Grade> homeworks = new HashSet<Grade>();

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

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	
	public Set<Grade> getHomeworks() {
		return homeworks;
	}

	public void setHomeworks(Set<Grade> homeworks) {
		this.homeworks = homeworks;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", username="
				+ username + ", password=" + password + ", clazz=" + clazz
				+ ", user=" + user + ", group=" + group + ", homeworks="
				+ homeworks + "]";
	}

}
