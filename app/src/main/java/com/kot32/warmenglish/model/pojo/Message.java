package com.kot32.warmenglish.model.pojo;

import java.util.Date;

public class Message {
	private int id;
	
	private String title;
	private String content;
	private Date date;
	//是哪一个老师发送的
	private User user;
	//是发给哪一个班级的
	private Class clazz;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Class getClazz() {
		return clazz;
	}
	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", title=" + title + ", content="
				+ content + ", date=" + date + ", user=" + user + ", clazz="
				+ clazz + "]";
	}
	
	public Message() {
		// TODO Auto-generated constructor stub
	}
	public Message( String title, String content, Date date, User user,
			Class clazz) {
		super();
		this.title = title;
		this.content = content;
		this.date = date;
		this.user = user;
		this.clazz = clazz;
	}
	
	
	
}
