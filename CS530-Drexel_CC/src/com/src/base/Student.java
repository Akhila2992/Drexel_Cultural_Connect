package com.src.base;

public class Student {

	private String Name;
	private String ID;
	private String mailId;
	private int college;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	
	public int getCollege() {
		return college;
	}
	public void setCollege(int college) {
		this.college = college;
	}

	
}
