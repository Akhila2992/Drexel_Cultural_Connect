package com.src.base;

public class StudyGroup {

	private String ID; 
	private String Name;
	private String Description;
	private String Creator_ID;
	private String Content;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getCreator_ID() {
		return Creator_ID;
	}
	public void setCreator_ID(String creator_ID) {
		Creator_ID = creator_ID;
	}
	
}
