package com.casino.casino.helpers;

public class UserNameChanger {

	
	
	String oldName;
	String newName;
	
	public UserNameChanger(String oldName, String newName) {
		super();
		this.oldName = oldName;
		this.newName = newName;
	}

	public String getOldName() {
		return oldName;
	}

	public void setOldName(String oldName) {
		this.oldName = oldName;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}
	
	
	
}
