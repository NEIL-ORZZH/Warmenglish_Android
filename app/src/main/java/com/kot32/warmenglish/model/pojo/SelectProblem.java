package com.kot32.warmenglish.model.pojo;

import java.util.Arrays;

public class SelectProblem {

	private int id;
	//题干
	private String des;
	//4个答案
	private String answers[]=new String[4];
	//正确答案
	private String answer;
	//属于哪一次作业的
	private Homework homework;
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
	public String[] getAnswers() {
		return answers;
	}
	public void setAnswers(String[] answers) {
		this.answers = answers;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Homework getHomework() {
		return homework;
	}
	public void setHomework(Homework homework) {
		this.homework = homework;
	}
	@Override
	public String toString() {
		return "SelectProblem [id=" + id + ", des=" + des + ", answers="
				+ Arrays.toString(answers) + ", answer=" + answer
				+ ", homework=" + homework + "]";
	}
	
	
}
