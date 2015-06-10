package com.kot32.warmenglish.model.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Homework {
	private int id;
	
	//本次作业的要求描述
	private String des;
	//布置的小组
	private Group group;
	//布置的时间
	private Date date;
	//选择题
	private Set<SelectProblem> selectProblems = new HashSet<SelectProblem>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Set<SelectProblem> getSelectProblems() {
		return selectProblems;
	}
	public void setSelectProblems(Set<SelectProblem> selectProblems) {
		this.selectProblems = selectProblems;
	}
	@Override
	public String toString() {
		return "Homework [id=" + id + ", des=" + des + ", group=" + group
				+ ", date=" + date + ", selectProblems=" + selectProblems + "]";
	}
	
	
}
