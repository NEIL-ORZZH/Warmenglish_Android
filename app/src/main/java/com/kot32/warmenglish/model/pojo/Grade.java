package com.kot32.warmenglish.model.pojo;

public class Grade {
	private int id;
	private float selectGrade;

	private Student student;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getSelectGrade() {
		return selectGrade;
	}

	public void setSelectGrade(float selectGrade) {
		this.selectGrade = selectGrade;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Grade [id=" + id + ", selectGrade=" + selectGrade
				+ ", student=" + student + "]";
	}
	
	
}
