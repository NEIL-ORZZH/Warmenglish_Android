package com.kot32.warmenglish.model.pojo;

import java.util.HashSet;
import java.util.Set;


public class Class {
	private int id;
	private String name;
	private String uuid;
	private User user;
	private String des;
	// 一个班级很多小组
	private Set<Group> groups = new HashSet<Group>();
	// 一个班级推送消息
	private Set<Message> messages = new HashSet<Message>();

	@Override
	public String toString() {
		return "Class [id=" + id + ", name=" + name + ", uuid=" + uuid
				+ ", user=" + user + ", des=" + des + ", groups=" + groups
				+ ", messages=" + messages + "]";
	}

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

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

}
