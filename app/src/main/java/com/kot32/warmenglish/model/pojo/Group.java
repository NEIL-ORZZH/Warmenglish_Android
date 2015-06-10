package com.kot32.warmenglish.model.pojo;

import java.util.HashSet;
import java.util.Set;

public class Group {
	private int id;
	private String name;

	private Class clazz;
	
	// 一个组很多学生
	private Set<Student> students = new HashSet<Student>();
	
	// 一个组很多作业
	private Set<Homework> homeworks = new HashSet<Homework>();

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

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<Homework> getHomeworks() {
		return homeworks;
	}

	public void setHomeworks(Set<Homework> homeworks) {
		this.homeworks = homeworks;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", clazz=" + clazz
				+ ", students=" + students + ", homeworks=" + homeworks + "]";
	}

	@Override
	public boolean equals(Object obj) {
		// 判断两个小组是不是同一个组，首先看是不是同一个班级
		if ((clazz.getId() == ((Group) obj).getClazz().getId())
				&& (getId() == ((Group) obj).getId())) {
			return true;
		} else {
			return false;
		}
	}

	public Group(String name, Class clazz) {
		super();
		this.name = name;
		this.clazz = clazz;
	}
	
	

}
