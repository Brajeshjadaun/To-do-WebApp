package com.servlet.student_to_do_web_app.dto;

public class Student {
	
	private int stId;
	private String stName;
	private String stEmail;
	private String password;
	private String gender;
	public Student(int stId, String stName, String stEmail, String password, String gender) {
		super();
		this.stId = stId;
		this.stName = stName;
		this.stEmail = stEmail;
		this.password = password;
		this.gender = gender;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getStId() {
		return stId;
	}
	public void setStId(int stId) {
		this.stId = stId;
	}
	public String getStName() {
		return stName;
	}
	public void setStName(String stName) {
		this.stName = stName;
	}
	public String getStEmail() {
		return stEmail;
	}
	public void setStEmail(String stEmail) {
		this.stEmail = stEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Id: " + stId + "| Name: " + stName + "| Email: " + stEmail + "| Gender: " + gender;
	}
	
	

}
